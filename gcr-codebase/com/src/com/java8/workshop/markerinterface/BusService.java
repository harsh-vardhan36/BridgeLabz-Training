package com.java8.workshop.markerinterface;

public class BusService implements TransportService {

    @Override
    public String getServiceName() {
        return "City Bus";
    }
}
