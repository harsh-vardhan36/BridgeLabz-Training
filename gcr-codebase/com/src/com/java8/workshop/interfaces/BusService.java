package com.java8.workshop.interfaces;

public class BusService implements TransportService {

    private String route;
    private double fare;

    public BusService(String route, double fare) {
        this.route = route;
        this.fare = fare;
    }

    @Override
    public String getServiceType() {
        return "Bus";
    }

    @Override
    public String getRoute() {
        return route;
    }

    @Override
    public double getFare() {
        return fare;
    }
}
