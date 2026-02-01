package com.java8.functional.unitconversion;

public class LogisticsApp {

    public static void main(String[] args) {

        double distanceKm = 120;
        double weightKg = 50;

        System.out.println("Distance in miles: " +
                UnitConverter.kmToMiles(distanceKm));

        System.out.println("Weight in pounds: " +
                UnitConverter.kgToPounds(weightKg));
    }
}

