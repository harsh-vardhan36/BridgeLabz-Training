package com.inheritance.vehicleandtransport;

public class Vehicle {
	int maxspeed;
	String fueltype;
	
	Vehicle(int maxspeed, String fueltype){
		this.maxspeed = maxspeed;
		this.fueltype = fueltype;
	}
	
	void displayinfo() {
		System.out.println("Max speed : " + maxspeed + " fueltype : " + fueltype);
	}
}