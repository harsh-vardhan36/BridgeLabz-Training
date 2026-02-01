package com.java8.workshop.foreach;

public class LiveSchedule {

    private String serviceType;   // Bus, Metro, Taxi
    private String route;
    private String arrivalTime;

    public LiveSchedule(String serviceType, String route, String arrivalTime) {
        this.serviceType = serviceType;
        this.route = route;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return serviceType + " | " + route + " | Arrives at: " + arrivalTime;
    }
}
