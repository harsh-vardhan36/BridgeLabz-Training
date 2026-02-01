package com.java8.workshop.lambdaexpression;

import java.util.*;

public class SmartCityTransportApp {

    public static void main(String[] args) {

        List<TransportSchedule> schedules = Arrays.asList(
            new TransportSchedule("Bus", "Route 12", 540, 30),
            new TransportSchedule("Metro", "Line A", 500, 40),
            new TransportSchedule("Taxi", "Airport", 520, 120),
            new TransportSchedule("EV Bus", "Green Loop", 510, 35)
        );

        System.out.println("=== Earliest Departure ===");
        schedules.stream()
                 .sorted((a, b) -> a.getDepartureTime() - b.getDepartureTime())
                 .forEach(System.out::println);

        System.out.println("\n=== Cheapest Transport ===");
        schedules.stream()
                 .sorted((a, b) -> Double.compare(a.getFare(), b.getFare()))
                 .forEach(System.out::println);

        System.out.println("\n=== Cheap & Early Options ===");
        schedules.stream()
                 .filter(s -> s.getFare() <= 50)
                 .sorted((a, b) -> a.getDepartureTime() - b.getDepartureTime())
                 .forEach(System.out::println);
    }
}
