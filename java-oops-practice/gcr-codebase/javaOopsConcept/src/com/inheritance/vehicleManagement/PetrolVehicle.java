package com.inheritance.vehicleManagement;

public class PetrolVehicle extends Vehicle implements Refuelable {

    private int fuelTankCapacity; // in liters

    public PetrolVehicle(String model, int maxSpeed, int fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Petrol Vehicle Details:");
        System.out.println("Model: " + model);
        System.out.println("Refueling petrol tank of " + fuelTankCapacity + " liters.");
    }
}