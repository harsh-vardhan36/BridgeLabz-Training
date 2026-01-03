package com.vehiclerentalapplication;
/* Vehicle Rental Application
Scenario: Build a system for renting bikes, cars, and trucks to customers. */

abstract class Vehicle implements Rentable {
	protected String vehicleNumber;
	protected String vehicleName;
	protected double baseRate;

	public Vehicle(String vehicleNumber, String vehicleName, double baseRate) {
		this.vehicleNumber = vehicleNumber;
		this.baseRate = baseRate;
		this.vehicleName = vehicleName;
	}

	// Encapsulation
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public double getBaseRate() {
		return baseRate;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}

	public void displayDetails() {
		System.out.println("Vehicle Name : " + vehicleName);
		System.out.println("Vehicle No : " + vehicleNumber);
		System.out.println("Base Rate  : Rs. " + baseRate + " per day");
	}
}