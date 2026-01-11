package com.artify;

public class User {
    private String name;
    private double walletBalance;

    public User(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public String getName() {
        return name;
    }

    public void deductBalance(double amount) {
        if (amount <= walletBalance)
            walletBalance -= amount;
        else
            System.out.println("Insufficient balance!");
    }
}

