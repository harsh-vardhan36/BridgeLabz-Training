package com.fundoo.notes.rabbit;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fundoo.notes.config.RabbitConfig;
import com.fundoo.notes.dto.NoteActivityEvent;

/**
 * Publishes a note activity event every time a note is created, changed,
 * or removed. Called from NoteServiceImpl right after each mutation is
 * saved. Fire-and-forget: a broker hiccup here must never fail the note
 * operation that triggered it.
 */
@Component
public class NoteActivityProducer {

    private static final Logger log = LoggerFactory.getLogger(NoteActivityProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public NoteActivityProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(String username, String action, Integer noteNumber, String noteTitle) {
        NoteActivityEvent event = new NoteActivityEvent(username, action, noteNumber, noteTitle, LocalDateTime.now());
        // Routing key e.g. "note.created", "note.tag_added" -- lets other
        // consumers subscribe to a subset (e.g. only "note.deleted") later
        // without touching this producer.
        String routingKey = "note." + action.toLowerCase();
        try {
            rabbitTemplate.convertAndSend(RabbitConfig.ACTIVITY_EXCHANGE, routingKey, event);
            log.info("Published activity event -> {}", event);
        } catch (Exception e) {
            log.error("Failed to publish activity event for note {} ({}): {}", noteNumber, action, e.getMessage(), e);
        }
    }
}
