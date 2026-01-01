package com.inheritance.vehicleandtransport;

public class Truck extends Vehicle{

	Truck(int maxspeed, String fueltype) {
		super(maxspeed, fueltype);
		// TODO Auto-generated constructor stub
	}
	int loadingcapacity = 4;
	void displayinfo() {
		System.out.println("maxspeed : " + maxspeed + " fueltype : " + fueltype + 
				" loadingcapacity : " + loadingcapacity);
	 }

}