package com.junit.datatest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    private static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public String formatDate(String inputDate) {
        if (inputDate == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        LocalDate date = LocalDate.parse(inputDate, INPUT_FORMAT);
        return date.format(OUTPUT_FORMAT);
    }
}
