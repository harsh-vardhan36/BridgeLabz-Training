package com.fundoo.notes.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fundoo.notes.config.RabbitConfig;
import com.fundoo.notes.dto.NoteActivityEvent;
import com.fundoo.notes.entity.NoteActivityLog;
import com.fundoo.notes.repository.NoteActivityLogRepository;

/**
 * Drains the note-activity queue and writes each event to the
 * note_activity_log table -- this is what turns the fire-and-forget
 * events into a queryable audit trail (see NoteService#getRecentActivity).
 */
@Component
public class NoteActivityListener {

    private static final Logger log = LoggerFactory.getLogger(NoteActivityListener.class);

    private final NoteActivityLogRepository activityLogRepository;

    public NoteActivityListener(NoteActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @RabbitListener(queues = RabbitConfig.ACTIVITY_QUEUE)
    public void handleActivity(NoteActivityEvent event) {
        log.info("Activity received: {}", event);

        NoteActivityLog logEntry = new NoteActivityLog();
        logEntry.setUsername(event.getUsername());
        logEntry.setAction(event.getAction());
        logEntry.setNoteNumber(event.getNoteNumber());
        logEntry.setNoteTitle(event.getNoteTitle());
        logEntry.setTimestamp(event.getTimestamp());

        try {
            activityLogRepository.save(logEntry);
        } catch (Exception e) {
            // Background job -- log and move on, nothing to report the
            // failure to.
            log.error("Failed to persist activity log for {}: {}", event, e.getMessage(), e);
        }
    }
}
