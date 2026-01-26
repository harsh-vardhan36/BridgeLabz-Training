package com.junit.passwordtest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
    }

    @Test
    void testTooShortPassword() {
        assertFalse(validator.isValid("Pass1"));
    }

    @Test
    void testMissingUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    @Test
    void testMissingDigit() {
        assertFalse(validator.isValid("Password"));
    }

    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}
