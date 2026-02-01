package com.java8.workshop.functionalinterfaces;

public class Main {

    public static void main(String[] args) {

        double baseFare = 20;
        double distance = 12; // km

        //  Bus fare calculation
        FareCalculator busFare =
                (fare, km) -> fare + (km * 2);

        //  Metro fare calculation
        FareCalculator metroFare =
                (fare, km) -> fare + (km * 1.5);

        //  Taxi fare calculation
        FareCalculator taxiFare =
                (fare, km) -> fare + (km * 10);

        System.out.println("Bus Fare: ₹" +
                busFare.calculateFare(baseFare, distance));

        System.out.println("Metro Fare: ₹" +
                metroFare.calculateFare(baseFare, distance));

        System.out.println("Taxi Fare: ₹" +
                taxiFare.calculateFare(baseFare, distance));
    }
}
