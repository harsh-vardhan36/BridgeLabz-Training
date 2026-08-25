package com.fundoo.notes.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fundoo.notes.config.RabbitConfig;
import com.fundoo.notes.dto.EmailMessage;

/**
 * Same job as com.fundoo.notes.jms.EmailProducer, published to RabbitMQ
 * instead of Artemis. Called alongside the JMS producer (not instead of
 * it) so the two brokers can be compared side by side -- watch this
 * queue fill up in the RabbitMQ management UI (localhost:15672) while
 * the JMS one is only visible in the app logs.
 */
@Component
public class RabbitEmailProducer {

    private static final Logger log = LoggerFactory.getLogger(RabbitEmailProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitEmailProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendWelcomeEmail(String toEmail, String name) {
        EmailMessage message = new EmailMessage(
                toEmail,
                "Welcome to Fundoo Notes!",
                "Hi " + name + ",\n\nYour Fundoo Notes account has been created successfully.\n\n" +
                        "Happy note-taking!"
        );
        publish(message);
    }

    public void sendPasswordResetEmail(String toEmail, String resetLink) {
        EmailMessage message = new EmailMessage(
                toEmail,
                "Reset your Fundoo Notes password",
                "We received a request to reset your password.\n\n" +
                        "Click the link below (valid for 15 minutes):\n" + resetLink +
                        "\n\nIf you didn't request this, you can ignore this email."
        );
        publish(message);
    }

    public void sendReminderEmail(String toEmail, String noteTitle, String noteContent, Integer noteNumber) {
        String preview = (noteContent == null || noteContent.isBlank())
                ? "(no content)"
                : (noteContent.length() > 200 ? noteContent.substring(0, 200) + "..." : noteContent);
        EmailMessage message = new EmailMessage(
                toEmail,
                "Reminder: " + noteTitle,
                "This is your reminder for note #" + noteNumber + " \"" + noteTitle + "\":\n\n" + preview
        );
        publish(message);
    }

    private void publish(EmailMessage message) {
        try {
            rabbitTemplate.convertAndSend(RabbitConfig.EMAIL_EXCHANGE, RabbitConfig.EMAIL_ROUTING_KEY, message);
            log.info("[RabbitMQ] Queued email job -> {}", message);
        } catch (Exception e) {
            // Never let a broker hiccup break registration/login/forgot-password.
            log.error("[RabbitMQ] Failed to queue email job for {}: {}", message.getTo(), e.getMessage(), e);
        }
    }
}
