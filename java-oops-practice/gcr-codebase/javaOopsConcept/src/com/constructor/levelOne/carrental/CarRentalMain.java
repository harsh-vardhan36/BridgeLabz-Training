package com.constructor.levelOne.carrental;

public class CarRentalMain {
	public static void main(String[] args) {
	     CarRental rental = new CarRental("Muskan", "Honda City", 5);
	     rental.displayDetails();
	     CarRental rental1 = new CarRental();
	     rental1.displayDetails();
}
}
