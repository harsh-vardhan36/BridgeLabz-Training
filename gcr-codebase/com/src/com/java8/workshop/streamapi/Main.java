package com.java8.workshop.streamapi;

import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        List<PassengerTrip> trips = Arrays.asList(
            new PassengerTrip("Route A", 30),
            new PassengerTrip("Route B", 40),
            new PassengerTrip("Route A", 30),
            new PassengerTrip("Route C", 50),
            new PassengerTrip("Route B", 40),
            new PassengerTrip("Route A", 30)
        );

        //  Total revenue per route
        Map<String, Double> revenueByRoute =
                trips.stream()
                     .collect(Collectors.groupingBy(
                         PassengerTrip::getRoute,
                         Collectors.summingDouble(PassengerTrip::getFare)
                     ));

        System.out.println("=== Revenue by Route ===");
        revenueByRoute.forEach((route, revenue) ->
            System.out.println(route + " → ₹" + revenue)
        );

        //  Passenger count per route
        Map<String, Long> passengersByRoute =
                trips.stream()
                     .collect(Collectors.groupingBy(
                         PassengerTrip::getRoute,
                         Collectors.counting()
                     ));

        System.out.println("\n=== Passenger Count by Route ===");
        passengersByRoute.forEach((route, count) ->
            System.out.println(route + " → " + count)
        );

        //  Top-used route
        String topRoute =
                passengersByRoute.entrySet()
                                  .stream()
                                  .max(Map.Entry.comparingByValue())
                                  .map(Map.Entry::getKey)
                                  .orElse("No Data");

        System.out.println("\nTop Used Route → " + topRoute);
    }
}
