package com.inheritance.vehicleandtransport;

public class MotorCycle extends Vehicle{

	MotorCycle(int maxspeed, String fueltype) {
		super(maxspeed, fueltype);
		
	}
	int cc = 400;
	void displayinfo() {
		System.out.println("maxspeed : " + maxspeed + " fueltype : " + fueltype + 
				" cc : " + cc);
	 }
}
