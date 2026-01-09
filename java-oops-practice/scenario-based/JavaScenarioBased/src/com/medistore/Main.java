package com.medistore;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Polymorphism: parent reference
        Medicine tablet = new Tablet(
                "Calpol",
                50.0,
                LocalDate.of(2026, 3, 1),
                20
        );

        Medicine syrup = new Syrup(
                "Cough Syrup",
                120.0,
                LocalDate.of(2027, 1, 10),
                10
        );

        Medicine injection = new Injection(
                "Insulin",
                300.0,
                LocalDate.of(2027, 2, 1),
                5
        );

        // Same method call, different behavior
        tablet.sell(5);
        syrup.sell(3);
        injection.sell(2);
    }
}
