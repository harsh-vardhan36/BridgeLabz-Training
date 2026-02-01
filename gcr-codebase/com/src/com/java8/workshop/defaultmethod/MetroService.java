package com.java8.workshop.defaultmethod;

public class MetroService implements TransportService {

    private String route;

    public MetroService(String route) {
        this.route = route;
    }

    @Override
    public String getServiceName() {
        return "Metro";
    }

    @Override
    public String getRoute() {
        return route;
    }
}
