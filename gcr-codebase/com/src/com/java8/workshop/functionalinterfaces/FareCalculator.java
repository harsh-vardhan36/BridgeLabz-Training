package com.java8.workshop.functionalinterfaces;

@FunctionalInterface
public interface FareCalculator {

    double calculateFare(double baseFare, double distance);

}
