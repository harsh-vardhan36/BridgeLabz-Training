package com.junit.usertest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    UserRegistration registration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> {
            registration.registerUser("john_doe", "john@example.com", "Password1");
        });
    }

    @Test
    void testInvalidUsernameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("jo", "john@example.com", "Password1");
        });
    }

    @Test
    void testInvalidEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john_doe", "johnexample.com", "Password1");
        });
    }

    @Test
    void testInvalidPasswordThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john_doe", "john@example.com", "pass");
        });
    }

    @Test
    void testNullInputsThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(null, null, null);
        });
    }
}
