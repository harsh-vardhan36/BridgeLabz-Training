package com.fundoo.notes.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundoo.notes.entity.User;
import com.fundoo.notes.exception.InvalidCredentialsException;
import com.fundoo.notes.exception.UserNotFoundException;
import com.fundoo.notes.jms.EmailProducer;
import com.fundoo.notes.rabbit.RabbitEmailProducer;
import com.fundoo.notes.repository.UserRepository;

/**
 * Reset tokens now live in Redis instead of the password_reset_tokens table.
 * That gets us auto-expiry for free (Redis drops the key itself after the
 * TTL) - no expiry column to check by hand and no cleanup job needed for
 * stale rows. The old PasswordResetToken entity/repository are left in
 * place (harmless, unused) in case you want to fall back to the DB version.
 */
@Service
public class PasswordResetService {

    private static final String KEY_PREFIX = "password-reset:";
    private static final Duration TOKEN_TTL = Duration.ofMinutes(15);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final StringRedisTemplate redisTemplate;
    private final EmailProducer emailProducer;
    private final RabbitEmailProducer rabbitEmailProducer;

    @Value("${app.frontend.reset-password-url}")
    private String resetPasswordUrl;

    public PasswordResetService(UserRepository userRepository,
                                PasswordEncoder passwordEncoder,
                                StringRedisTemplate redisTemplate,
                                EmailProducer emailProducer,
                                RabbitEmailProducer rabbitEmailProducer) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.redisTemplate = redisTemplate;
        this.emailProducer = emailProducer;
        this.rabbitEmailProducer = rabbitEmailProducer;
    }

    public String forgotPassword(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        }

        String token = UUID.randomUUID().toString();

        // SET password-reset:<token> = email, expires automatically in 15 min
        redisTemplate.opsForValue().set(KEY_PREFIX + token, user.getEmail(), TOKEN_TTL);

        String resetLink = resetPasswordUrl + "?token=" + token;
        emailProducer.sendPasswordResetEmail(user.getEmail(), resetLink);
        rabbitEmailProducer.sendPasswordResetEmail(user.getEmail(), resetLink);

        // Still returned here so the flow is testable without SMTP set up;
        // in a real deployment you'd drop this and rely solely on the email.
        return token;
    }

    public void resetPassword(String token, String newPassword) {
        String key = KEY_PREFIX + token;
        String email = redisTemplate.opsForValue().get(key);

        if (email == null) {
            throw new InvalidCredentialsException("Token is invalid, expired, or already used!");
        }

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        user.setPasswordChangedAt(LocalDateTime.now());
        userRepository.save(user);

        // One-time use: delete immediately so the same token can't be replayed.
        redisTemplate.delete(key);
    }
}
