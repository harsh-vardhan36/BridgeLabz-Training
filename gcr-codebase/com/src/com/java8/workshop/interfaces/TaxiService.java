package com.java8.workshop.interfaces;

public class TaxiService implements TransportService {

    private String route;
    private double fare;

    public TaxiService(String route, double fare) {
        this.route = route;
        this.fare = fare;
    }

    @Override
    public String getServiceType() {
        return "Taxi";
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
