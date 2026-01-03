package com.ewalletapplication;

import java.time.LocalDateTime;

class Transaction {

    private String description;
    private double amount;
    private LocalDateTime time;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public String getDetails() {
        return time + " | " + description + " | ₹" + amount;
    }
}