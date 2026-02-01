package com.java8.stream.transformingname;

import java.util.List;

public class CustomerNameTransform {
    public static void main(String[] args) {

        List<String> customers = List.of(
            "rahul",
            "Anita",
            "vijay",
            "Sneha"
        );

        customers.stream()
                 .map(String::toUpperCase)   // transform to uppercase
                 .sorted()                   // alphabetical order
                 .forEach(System.out::println);
    }
}
