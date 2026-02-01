package com.java8.workshop.defaultmethod;

public interface TransportService {

    String getServiceName();
    String getRoute();

    // Default method 
    default void printServiceDetails() {
        System.out.println(
            "Service: " + getServiceName() +
            " | Route: " + getRoute()
        );
    }
}
