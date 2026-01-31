package com.java8.functional.rentalsystem;

public class Main {
    public static void main(String[] args) {

        RentalVehicle car = new Car();
        RentalVehicle bike = new Bike();
        RentalVehicle bus = new Bus();

        car.rent();
        bike.rent();
        bus.rent();

        bus.returnVehicle();
        bike.returnVehicle();
        car.returnVehicle();
    }
}

