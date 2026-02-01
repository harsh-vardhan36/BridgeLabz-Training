package com.java8.workshop.collectors;

import java.time.LocalTime;

public class PassengerTrip {

    private String route;
    private double fare;
    private LocalTime tripTime;

    public PassengerTrip(String route, double fare, LocalTime tripTime) {
        this.route = route;
        this.fare = fare;
        this.tripTime = tripTime;
    }

    public String getRoute() {
        return route;
    }

    public double getFare() {
        return fare;
    }

    public LocalTime getTripTime() {
        return tripTime;
    }
}
