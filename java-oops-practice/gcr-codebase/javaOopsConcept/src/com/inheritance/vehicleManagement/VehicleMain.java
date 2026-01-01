package com.inheritance.vehicleManagement;

public class VehicleMain {
	public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 225, 75);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180, 40);

        ev.charge();
        System.out.println();

        pv.refuel();
    }
}
