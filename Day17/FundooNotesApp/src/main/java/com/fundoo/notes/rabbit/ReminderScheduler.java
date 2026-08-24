package com.fundoo.notes.rabbit;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.repository.NoteRepository;

/**
 * Reminder scheduling, option 3 from the design discussion: a DB poller
 * decides WHEN a reminder is due (re-reading the note each tick, so an
 * edited/cancelled/deleted reminder is naturally respected), then hands
 * the actual delivery off to RabbitMQ (RabbitEmailProducer -> the same
 * fundoo.email.queue / RabbitEmailListener used for welcome and
 * password-reset mail) so the poll loop itself never blocks on SMTP.
 *
 * RabbitMQ is not the scheduler here -- the DB is. RabbitMQ's job is
 * just reliable, decoupled delivery once the poller decides a reminder
 * is due.
 */
@Component
public class ReminderScheduler {

    private static final Logger log = LoggerFactory.getLogger(ReminderScheduler.class);

    private final NoteRepository noteRepository;
    private final RabbitEmailProducer rabbitEmailProducer;
    private final NoteActivityProducer noteActivityProducer;

    public ReminderScheduler(NoteRepository noteRepository,
                              RabbitEmailProducer rabbitEmailProducer,
                              NoteActivityProducer noteActivityProducer) {
        this.noteRepository = noteRepository;
        this.rabbitEmailProducer = rabbitEmailProducer;
        this.noteActivityProducer = noteActivityProducer;
    }

    // Every 60s by default -- override with app.reminders.poll-interval-ms
    // if you want tighter precision. Reminders fire up to one interval late,
    // never early.
    @Scheduled(fixedRateString = "${app.reminders.poll-interval-ms:60000}")
    @Transactional
    public void dispatchDueReminders() {
        List<Note> dueNotes = noteRepository.findDueReminders(LocalDateTime.now());
        if (dueNotes.isEmpty()) {
            return;
        }

        log.info("Found {} due reminder(s)", dueNotes.size());

        for (Note note : dueNotes) {
            // Flip the flag first so a slow email send (or a crash mid-loop)
            // can't cause the same reminder to be picked up and re-sent on
            // the next tick.
            note.setReminderSent(true);
            noteRepository.save(note);

            String toEmail = note.getUser().getEmail();
            rabbitEmailProducer.sendReminderEmail(toEmail, note.getTitle(), note.getContent(), note.getNoteNumber());
            noteActivityProducer.publish(toEmail, "REMINDER_SENT", note.getNoteNumber(), note.getTitle());
        }
    }
}
