package com.java8.workshop.streamapi;

public class PassengerTrip {

    private String route;
    private double fare;

    public PassengerTrip(String route, double fare) {
        this.route = route;
        this.fare = fare;
    }

    public String getRoute() {
        return route;
    }

    public double getFare() {
        return fare;
    }
}
