package com.app.greeting.service;

import org.springframework.stereotype.Service;

import com.app.greeting.model.RegistrationUser;
import com.app.greeting.repository.UserRepository;

@Service
public class RegistrationService {

    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(RegistrationUser user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            return false;
        }

        userRepository.save(user);

        return true;
    }

    public RegistrationUser loginUser(String email, String password) {

        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }
}