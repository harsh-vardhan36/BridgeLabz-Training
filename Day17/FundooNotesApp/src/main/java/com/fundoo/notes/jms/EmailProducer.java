package com.fundoo.notes.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fundoo.notes.config.JmsConfig;
import com.fundoo.notes.dto.EmailMessage;

/**
 * Publishes email jobs to the JMS queue instead of sending mail inline.
 * Callers (registration, forgot-password) return to the client immediately;
 * EmailListener does the actual (slow, failure-prone) SMTP call afterwards.
 */
@Component
public class EmailProducer {

    private static final Logger log = LoggerFactory.getLogger(EmailProducer.class);

    private final JmsTemplate jmsTemplate;

    public EmailProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
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

    private void publish(EmailMessage message) {
        try {
            jmsTemplate.convertAndSend(JmsConfig.EMAIL_QUEUE, message);
            log.info("Queued email job -> {}", message);
        } catch (Exception e) {
            // Never let a broker hiccup break registration/login/forgot-password.
            log.error("Failed to queue email job for {}: {}", message.getTo(), e.getMessage(), e);
        }
    }
}
