package com.java8.workshop.defaultmethod;

public class TaxiService implements TransportService {

    private String route;

    public TaxiService(String route) {
        this.route = route;
    }

    @Override
    public String getServiceName() {
        return "Taxi";
    }

    @Override
    public String getRoute() {
        return route;
    }
}
