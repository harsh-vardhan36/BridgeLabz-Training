package com.java8.workshop.interfaces;

public class MetroService implements TransportService {

    private String route;
    private double fare;

    public MetroService(String route, double fare) {
        this.route = route;
        this.fare = fare;
    }

    @Override
    public String getServiceType() {
        return "Metro";
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
