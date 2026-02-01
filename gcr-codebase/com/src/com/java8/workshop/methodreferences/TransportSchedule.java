package com.java8.workshop.methodreferences;

public class TransportSchedule {

    private String type;
    private String route;
    private double fare;

    public TransportSchedule(String type, String route, double fare) {
        this.type = type;
        this.route = route;
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return type + " | " + route + " | ₹" + fare;
    }
}
