package com.parkease;

public class ParkEaseApp {
    public static void main(String[] args) {

        ParkingSlot slot1 = new ParkingSlot("A1", "Car");

        Vehicle car = new Car("MH12AB1234");

        if (slot1.assignSlot(car)) {
            System.out.println(" Slot Assigned");
            System.out.println("Parking Charge: $" +
                    car.calculateCharges(4));
        } else {
            System.out.println(" Slot Not Available");
        }

        slot1.showLog();
        slot1.releaseSlot();
    }
}
