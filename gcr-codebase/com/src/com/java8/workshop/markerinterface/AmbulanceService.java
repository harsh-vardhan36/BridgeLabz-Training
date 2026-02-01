package com.java8.workshop.markerinterface;

public class AmbulanceService implements TransportService, EmergencyService {

    @Override
    public String getServiceName() {
        return "Ambulance";
    }
}
