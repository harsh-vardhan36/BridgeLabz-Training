package com.java8.functional.dateformat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateFormatUtil {

    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}
