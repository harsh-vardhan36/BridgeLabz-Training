package com.java8.functional.vehicledashboard;

public class DashboardApp {

    public static void main(String[] args) {

        Vehicle petrolCar = new PetrolCar();
        Vehicle electricCar = new ElectricCar();

        petrolCar.displaySpeed();
        petrolCar.displayBatteryStatus();   

        electricCar.displaySpeed();
        electricCar.displayBatteryStatus(); 
    }
}
