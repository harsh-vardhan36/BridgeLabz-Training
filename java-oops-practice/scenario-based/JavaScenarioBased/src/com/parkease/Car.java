package com.parkease;


class Car extends Vehicle {

    public Car(String number) {
        super(number, 50);
    }

    @Override
    public double calculateCharges(int hours) {
        return baseRate * hours;
    }
}
