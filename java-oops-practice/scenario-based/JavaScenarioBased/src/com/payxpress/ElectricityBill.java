package com.payxpress;

class ElectricityBill extends Bill {

    public ElectricityBill(double amount, String dueDate) {
        super("Electricity", amount, dueDate);
    }

    public void sendReminder() {
        System.out.println(" Electricity bill due on " + dueDate);
    }
}
