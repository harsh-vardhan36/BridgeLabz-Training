package com.tourmate;

import java.util.List;

public abstract class Trip {
    protected String destination;
    protected int duration;
    protected Hotel hotel;
    protected Transport transport;
    protected List<Activity> activities;

    public Trip(String destination, int duration, Hotel hotel, Transport transport, List<Activity> activities) {
        this.destination = destination;
        this.duration = duration;
        this.hotel = hotel;
        this.transport = transport;
        this.activities = activities;
    }

    public double getTotalCost() {
        double total = hotel.getCost() + transport.getCost();
        for (Activity a : activities) {
            total += a.getCost();
        }
        return total;
    }

    public void showSummary() {
        System.out.println("Destination: " + destination);
        System.out.println("Duration: " + duration + " days");
        System.out.println("Hotel: " + hotel.getName());
        System.out.println("Transport: " + transport.getType());
        System.out.println("Total Cost: " + getTotalCost());
    }
}
