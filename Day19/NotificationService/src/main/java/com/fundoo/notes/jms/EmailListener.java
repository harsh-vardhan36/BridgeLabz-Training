package com.fundoo.notes.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.fundoo.notes.config.JmsConfig;
import com.fundoo.notes.dto.EmailMessage;

/**
 * Consumes EmailMessage jobs off the queue and sends them via SMTP.
 * Runs on a JMS listener thread, so it never blocks the HTTP request that
 * triggered it (registration / forgot-password).
 */
@Component
public class EmailListener {

    private static final Logger log = LoggerFactory.getLogger(EmailListener.class);

    private final JavaMailSender mailSender;

    @Value("${app.mail.enabled:false}")
    private boolean mailEnabled;

    @Value("${app.mail.from}")
    private String fromAddress;

    public EmailListener(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @JmsListener(destination = JmsConfig.EMAIL_QUEUE)
    public void handleEmail(EmailMessage message) {
        if (!mailEnabled) {
         
            log.info("[MAIL DISABLED] Would send to {} | subject='{}' | body:\n{}",
                    message.getTo(), message.getSubject(), message.getBody());
            return;
        }

        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(fromAddress);
            mail.setTo(message.getTo());
            mail.setSubject(message.getSubject());
            mail.setText(message.getBody());
            mailSender.send(mail);
            log.info("Email sent to {}", message.getTo());
        } catch (Exception e) {
            // Swallow: this is a background job, there's no HTTP request
            // left to report the failure to. Logging is the recovery point;
            // Artemis will still ack the message so it isn't retried forever.
            log.error("Failed to send email to {}: {}", message.getTo(), e.getMessage(), e);
        }
    }
}
