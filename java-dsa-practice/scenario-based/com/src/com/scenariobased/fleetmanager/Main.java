package com.scenariobased.fleetmanager;

public class Main {
    public static void main(String[] args) {

        // Combined sorted lists from different depots
        int[] vehicleMileage = { 5000, 8000, 12000, 3000, 7000, 15000 };

        MaintenanceSorter fleet = new MaintenanceSorter();

        System.out.println("Before creating master schedule:");
        fleet.display(vehicleMileage);

        fleet.mergeSort(vehicleMileage, 0, vehicleMileage.length - 1);

        System.out.println("After creating master schedule:");
        fleet.display(vehicleMileage);
    }
}
