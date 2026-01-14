package com.payxpress;
public class Main {
    public static void main(String[] args) {

        Bill electricity = new ElectricityBill(1200, "20-Jan");
        Bill water = new WaterBill(400, "18-Jan");
        Bill internet = new InternetBill(999, "22-Jan");

        electricity.sendReminder();
        water.sendReminder();
        internet.sendReminder();

        electricity.pay();

        double lateAmount = water.calculateLateFee(50);
        System.out.println("Water bill with late fee: " + lateAmount);
    }
}
