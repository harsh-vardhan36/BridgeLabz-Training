package com.java8.functional.lengthchecker;

import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        int limit = 20;

        Function<String, Integer> lengthCalculator =
                message -> message.length();

        String message = "Java 8 Functional Interface";

        int length = lengthCalculator.apply(message);

        if (length > limit) {
            System.out.println("Message exceeds limit (" + length + " characters)");
        } else {
            System.out.println("Message is within limit (" + length + " characters)");
        }
    }
}
