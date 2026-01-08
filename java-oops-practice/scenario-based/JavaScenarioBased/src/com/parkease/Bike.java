package com.parkease;

class Bike extends Vehicle {

    public Bike(String number) {
        super(number, 30);
    }

    @Override
    public double calculateCharges(int hours) {
        return baseRate * hours;
    }
}

