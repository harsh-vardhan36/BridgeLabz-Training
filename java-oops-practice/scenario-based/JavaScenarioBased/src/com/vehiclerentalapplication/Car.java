package com.vehiclerentalapplication;

class Car extends Vehicle {

    public Car(String vehicleNumber, String vehicleName,  double baseRate) {
        super(vehicleNumber, vehicleName, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        double surcharge = 500;
        return (baseRate * days) + surcharge;
    }
}