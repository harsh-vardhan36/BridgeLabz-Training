package com.java8.workshop.lambdaexpression;

class TransportSchedule {
    String type;          
    String route;
    int departureTime;    
    double fare;

    TransportSchedule(String type, String route, int departureTime, double fare) {
        this.type = type;
        this.route = route;
        this.departureTime = departureTime;
        this.fare = fare;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return type + " | " + route + " | Time: " + departureTime + " | ₹" + fare;
    }
}
