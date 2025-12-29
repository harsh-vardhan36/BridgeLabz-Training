package com.constructor.levelOne.vehicle;

public class VehichleMain {
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle("Amit pandey", "Car" );
		v1.displayVehicleDetails();
		
		Vehicle v2 = new Vehicle("Muskan Gupta",  "Bike");
		Vehicle.updateRegistrationFee(700);
		v1.displayVehicleDetails();
	}
}
