package com.java8.workshop.interfaces;

public interface TransportService {

    String getServiceType();
    String getRoute();
    double getFare();

    // Default method (shared behavior)
    default void printServiceDetails() {
        System.out.println(
            getServiceType() + " | Route: " + getRoute() + " | Fare: ₹" + getFare()
        );
    }
}
