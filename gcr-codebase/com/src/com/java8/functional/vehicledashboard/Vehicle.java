package com.java8.functional.vehicledashboard;

public interface Vehicle {

    void displaySpeed();

    // New optional feature
    default void displayBatteryStatus() {
        System.out.println("Battery status not applicable for this vehicle.");
    }
}
