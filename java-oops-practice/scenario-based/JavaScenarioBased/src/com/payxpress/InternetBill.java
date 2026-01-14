package com.payxpress;
class InternetBill extends Bill {

    public InternetBill(double amount, String dueDate) {
        super("Internet", amount, dueDate);
    }

    public void sendReminder() {
        System.out.println(" Internet service will stop after " + dueDate);
    }
}
