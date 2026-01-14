package com.payxpress;
class WaterBill extends Bill {

    public WaterBill(double amount, String dueDate) {
        super("Water", amount, dueDate);
    }

    public void sendReminder() {
        System.out.println(" Water bill pending. Due date: " + dueDate);
    }
}
