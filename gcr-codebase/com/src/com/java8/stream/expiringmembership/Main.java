package com.java8.stream.expiringmembership;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Member> members = List.of(
            new Member("Amit", LocalDate.now().plusDays(10)),
            new Member("Riya", LocalDate.now().plusDays(40)),
            new Member("Karan", LocalDate.now().plusDays(25)),
            new Member("Sneha", LocalDate.now().minusDays(2))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        members.stream()
               .filter(m -> !m.getExpiryDate().isBefore(today))   // not already expired
               .filter(m -> m.getExpiryDate().isBefore(next30Days))
               .forEach(System.out::println);
    }
}
