package com.inheritance.vehicleManagement;

public class ElectricVehicle extends Vehicle {

    private int batteryCapacity; 

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Electric Vehicle Details:");
        System.out.println("Model: " + model);
        System.out.println("Charging battery of " + batteryCapacity + " kWh.");
    }
}