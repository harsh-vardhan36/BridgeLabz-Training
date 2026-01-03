package com.vehiclerentalapplication;

class Bike extends Vehicle {

    public Bike(String vehicleNumber, String vehicleName,  double baseRate) {
        super(vehicleNumber, vehicleName, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days; 
    }
}