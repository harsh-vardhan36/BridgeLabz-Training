package com.cabbygo;

public class Vehicle {
    protected String vehicleNumber;
    protected int capacity;
    protected String type;

    protected double baseFare;
    protected double ratePerKm;

    public Vehicle(String vehicleNumber, int capacity, String type, double baseFare, double ratePerKm) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
        this.baseFare = baseFare;
        this.ratePerKm = ratePerKm;
    }

    public double calculateFare(double distance) {
        return baseFare + distance * ratePerKm;
    }

    public String getType() {
        return type;
    }
}
