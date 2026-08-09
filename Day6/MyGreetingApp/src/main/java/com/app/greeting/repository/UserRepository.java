package com.app.greeting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.greeting.model.RegistrationUser;

public interface UserRepository
        extends JpaRepository<RegistrationUser, Long> {

    Optional<RegistrationUser> findByEmail(String email);

    boolean existsByEmail(String email);
}