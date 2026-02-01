package com.java8.workshop.collectors;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        List<PassengerTrip> trips = Arrays.asList(
            new PassengerTrip("Route A", 30, LocalTime.of(8, 30)),
            new PassengerTrip("Route B", 40, LocalTime.of(10, 15)),
            new PassengerTrip("Route A", 30, LocalTime.of(18, 45)),
            new PassengerTrip("Route C", 50, LocalTime.of(21, 10)),
            new PassengerTrip("Route B", 40, LocalTime.of(7, 50))
        );

        //  groupingBy() → passengers grouped by route
        Map<String, List<PassengerTrip>> tripsByRoute =
                trips.stream()
                     .collect(Collectors.groupingBy(PassengerTrip::getRoute));

        System.out.println("=== Trips Grouped by Route ===");
        tripsByRoute.forEach((route, list) ->
            System.out.println(route + " → " + list.size() + " trips")
        );

        //  partitioningBy() → peak vs non-peak trips
        Map<Boolean, List<PassengerTrip>> peakPartition =
                trips.stream()
                     .collect(Collectors.partitioningBy(
                         t -> isPeakHour(t.getTripTime())
                     ));

        System.out.println("\n=== Peak Trips === " + peakPartition.get(true).size());
        System.out.println("=== Non-Peak Trips === " + peakPartition.get(false).size());

        //  summarizingDouble() → fare statistics
        DoubleSummaryStatistics fareStats =
                trips.stream()
                     .collect(Collectors.summarizingDouble(PassengerTrip::getFare));

        System.out.println("\n=== Fare Statistics ===");
        System.out.println("Total Fare: ₹" + fareStats.getSum());
        System.out.println("Average Fare: ₹" + fareStats.getAverage());
        System.out.println("Max Fare: ₹" + fareStats.getMax());
        System.out.println("Min Fare: ₹" + fareStats.getMin());
    }

    // Peak hours: 7–10 AM, 5–8 PM
    private static boolean isPeakHour(LocalTime time) {
        return (time.isAfter(LocalTime.of(6, 59)) && time.isBefore(LocalTime.of(10, 1))) ||
               (time.isAfter(LocalTime.of(16, 59)) && time.isBefore(LocalTime.of(20, 1)));
    }
}
