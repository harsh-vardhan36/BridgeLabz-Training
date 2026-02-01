package com.java8.workshop.markerinterface;

public class FireService implements TransportService, EmergencyService {

    @Override
    public String getServiceName() {
        return "Fire Service";
    }
}
