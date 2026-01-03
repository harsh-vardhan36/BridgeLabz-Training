package com.vehiclerentalapplication;

import java.util.Scanner;

class Main {

	public static void displayMenu() {
		
		System.out.println("-------------------------------------------------------");
		System.out.println("|      Welcome to Vehicle Rental Centre       |");
		System.out.println("-------------------------------------------------------");
		System.out.println();
	}
    public static void main(String[] args) {

    	Scanner input =new Scanner(System.in);
        Customer customer = new Customer();

        customer.setName("Harsh Vardhan ");

        Vehicle[] vehicles = {
            new Bike("BIKE101", " Royal Enfield Classic 350", 800),
            new Car("CAR101", "Tata Nexon", 1000),
            new Truck("TRUCK101", "Mahindra Jeeto", 2500)
        };
        
        displayMenu();
        System.out.print("Enter the number of days to rent the vehicle: ");
        int days = input.nextInt();

        System.out.println("\nCustomer : " + customer.getName());
        System.out.println("\n--------------------------------\n");

        for (Vehicle v : vehicles) {

            v.displayDetails();
            System.out.println("Rental Days : " + days);
            System.out.println("Total Rent  : Rs. " + v.calculateRent(days));
            System.out.println("\n--------------------------------\n");
        }
        
        input.close();
    }
}
