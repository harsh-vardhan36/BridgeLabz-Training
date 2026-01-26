package com.triplog;

import java.util.*;
import java.util.regex.*;

public class TravelStats {

    // Simple city regex (capitalized words)
    private static final Pattern CITY_PATTERN =
            Pattern.compile("\\b[A-Z][a-z]+\\b");

    public static void analyze(List<Trip> trips) {

        Set<String> uniqueCountries = new HashSet<>();
        Map<String, Integer> cityCount = new HashMap<>();

        System.out.println("Trips longer than 5 days:");
        for (Trip t : trips) {

            if (t.getDurationDays() > 5) {
                System.out.println(t);
            }

            uniqueCountries.add(t.getCountry());
            cityCount.put(t.getCity(),
                    cityCount.getOrDefault(t.getCity(), 0) + 1);

            // Regex over notes
            Matcher matcher = CITY_PATTERN.matcher(t.getNotes());
            while (matcher.find()) {
                // demonstration of regex usage
                matcher.group();
            }
        }

        System.out.println("\nUnique countries visited:");
        System.out.println(uniqueCountries);

        System.out.println("\nTop 3 most visited cities:");
        cityCount.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(e ->
                        System.out.println(e.getKey() + " → " + e.getValue()));
    }
}
