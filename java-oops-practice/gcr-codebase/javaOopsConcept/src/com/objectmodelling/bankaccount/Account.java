package com.objectmodelling.bankaccount;

import java.util.ArrayList;
import java.util.List;

// Account class
public class Account {
    private int accountNumber;
    private double balance;
    private Bank bank;  // Association: Account linked to a Bank

    public Account(int accountNumber, Bank bank) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.balance = 0.0; // default balance
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public Bank getBank() {
        return bank;
    }
}



