package com.parkease;

class Truck extends Vehicle {

    public Truck(String number) {
        super(number, 80);
    }

    @Override
    public double calculateCharges(int hours) {
        double penalty = (hours > 5) ? 200 : 0;
        return (baseRate * hours) + penalty;
    }
}
