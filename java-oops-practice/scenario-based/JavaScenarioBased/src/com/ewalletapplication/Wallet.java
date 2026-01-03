package com.ewalletapplication;

import java.util.ArrayList;
import java.util.List;

abstract class Wallet {

    private double balance;
    protected List<Transaction> transactions = new ArrayList<>();

    protected Wallet(double initialBalance) {
        this.balance = initialBalance;
        transactions.add(
            new Transaction("Wallet Created", initialBalance)
        );
    }

    public double getBalance() {
        return balance;
    }

    protected boolean deduct(double amount, String reason) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(reason, amount));
            return true;
        }
        return false;
    }

    protected void credit(double amount, String reason) {
        balance += amount;
        transactions.add(new Transaction(reason, amount));
    }

    public void printTransactionHistory() {
        System.out.println("---- Transaction History ----");
        for (Transaction t : transactions) {
            System.out.println(t.getDetails());
        }
    }

    public abstract double getTransferLimit();
}
