package com.cabbygo;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Sedan("MH12AB1234");
        Driver driver = new Driver("Rahul", "LIC9876", 4.8);

        IRideService ride = new RideService();
        ride.bookRide(vehicle, driver, 10);
        ride.endRide();
    }
}
