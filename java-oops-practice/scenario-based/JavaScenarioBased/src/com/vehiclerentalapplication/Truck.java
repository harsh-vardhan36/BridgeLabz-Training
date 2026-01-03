package com.vehiclerentalapplication;

class Truck extends Vehicle {

    public Truck(String vehicleNumber, String vehicleName,  double baseRate) {
        super(vehicleNumber, vehicleName, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        double surcharge = 1000;
        return (baseRate * days) + surcharge;
    }
}