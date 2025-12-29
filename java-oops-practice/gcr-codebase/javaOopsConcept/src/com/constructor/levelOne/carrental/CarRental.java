package com.constructor.levelOne.carrental;

public class CarRental {
	String customerName; 
	String carModel;
	int rentalDays;
	double costPerDay;
    double totalCost;
    
	 CarRental() {
		    customerName = "abc";
	        carModel = "xyz";
	        rentalDays = 1;
	        costPerDay = 1000;
	        calculateTotalCost();
	    }

	    // Parameterized Constructor
	    CarRental(String customerName, String carModel, int rentalDays) {
	        this.customerName = customerName;
	        this.carModel = carModel;
	        this.rentalDays = rentalDays;
	        this.costPerDay = 1000;
	        calculateTotalCost();
	    }

	    // Method to calculate total cost
	    void calculateTotalCost() {
	        totalCost = rentalDays * costPerDay;
	    }

	    // Method to display rental details
	    void displayDetails() {
	        System.out.println("Customer Name: " + customerName);
	        System.out.println("Car Model: " + carModel);
	        System.out.println("Rental Days: " + rentalDays);
	        System.out.println("Total Cost: ₹" + totalCost);
	    }
}
