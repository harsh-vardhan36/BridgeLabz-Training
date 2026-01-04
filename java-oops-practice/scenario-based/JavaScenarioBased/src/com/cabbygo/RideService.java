package com.cabbygo;

public class RideService implements IRideService {
    private double fare;
    private boolean rideActive;

    public void bookRide(Vehicle vehicle, Driver driver, double distance) {
        fare = vehicle.calculateFare(distance);
        rideActive = true;

        System.out.println("Ride booked");
        System.out.println("Driver: " + driver.getName());
        System.out.println("Vehicle Type: " + vehicle.getType());
        System.out.println("Fare: ₹" + fare);
    }

    public void endRide() {
        if (rideActive) {
            System.out.println("Ride ended. Total Fare: ₹" + fare);
            rideActive = false;
        } else {
            System.out.println("No active ride");
        }
    }
}
