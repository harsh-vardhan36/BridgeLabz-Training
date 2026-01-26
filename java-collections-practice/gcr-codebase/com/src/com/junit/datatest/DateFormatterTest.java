package com.junit.datatest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDateFormatting() {
        assertEquals("25-12-2024", formatter.formatDate("2024-12-25"));
        assertEquals("01-01-2023", formatter.formatDate("2023-01-01"));
    }

    @Test
    void testInvalidDateFormatThrowsException() {
        assertThrows(DateTimeParseException.class, () -> {
            formatter.formatDate("25-12-2024");
        });
    }

    @Test
    void testInvalidDateValueThrowsException() {
        assertThrows(DateTimeParseException.class, () -> {
            formatter.formatDate("2024-13-40");
        });
    }

    @Test
    void testNullDateThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate(null);
        });
    }
}
