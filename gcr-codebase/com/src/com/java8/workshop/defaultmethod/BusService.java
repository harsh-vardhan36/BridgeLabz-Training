package com.java8.workshop.defaultmethod;

public class BusService implements TransportService {

    private String route;

    public BusService(String route) {
        this.route = route;
    }

    @Override
    public String getServiceName() {
        return "Bus";
    }

    @Override
    public String getRoute() {
        return route;
    }
}
