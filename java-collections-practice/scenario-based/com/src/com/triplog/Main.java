package com.triplog;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String file = "trips.ser";

        try {
            List<Trip> trips = Arrays.asList(
                    new Trip("Paris", "France", 7,
                            "Loved walking around Paris and nearby cities"),
                    new Trip("Rome", "Italy", 4,
                            "Rome history is unmatched"),
                    new Trip("Paris", "France", 6,
                            "Second visit to Paris was amazing"),
                    new Trip("Berlin", "Germany", 3,
                            "Berlin nightlife")
            );

            TravelStore.saveTrips(trips, file);

            List<Trip> loadedTrips = TravelStore.loadTrips(file);

            TravelStats.analyze(loadedTrips);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
