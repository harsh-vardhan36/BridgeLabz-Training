package com.java8.functional.vehicledashboard;

public class ElectricCar implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Speed: 100 km/h");
    }

    @Override
    public void displayBatteryStatus() {
        System.out.println("Battery: 75%");
    }
}
