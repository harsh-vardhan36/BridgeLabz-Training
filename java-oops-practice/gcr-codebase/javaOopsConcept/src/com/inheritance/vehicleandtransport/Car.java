package com.inheritance.vehicleandtransport;

public class Car extends Vehicle{

	Car(int maxspeed, String fueltype) {
		super(maxspeed, fueltype);
		// TODO Auto-generated constructor stub
	}
	
	int seatcapacity = 4;
	void displayinfo() {
		System.out.println("maxspeed : " + maxspeed + " fueltype : " + fueltype + 
				" seatcapacity : " + seatcapacity);
	 }
}
