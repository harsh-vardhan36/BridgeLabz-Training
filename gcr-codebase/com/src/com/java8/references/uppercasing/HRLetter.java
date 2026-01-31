package com.java8.references.uppercasing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HRLetter {

    public static void main(String[] args) {

        List<String> employeeNames = Arrays.asList(
                "Rahul",
                "Anita",
                "Suresh",
                "Neha"
        );

        List<String> upperCaseNames = employeeNames.stream()
                .map(String::toUpperCase)   // method reference
                .collect(Collectors.toList());

        upperCaseNames.forEach(System.out::println);
    }
}
