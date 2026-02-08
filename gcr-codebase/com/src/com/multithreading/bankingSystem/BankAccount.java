package com.multithreading.bankingSystem;
import java.time.LocalDateTime;

public class BankAccount {

    private int balance = 10000;

    public synchronized boolean withdraw(String customerName, int amount) {

        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(500); // simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;

            System.out.println("Transaction successful: " + customerName +
                    ", Amount: " + amount +
                    ", Balance: " + balance +
                    ", Time: " + LocalDateTime.now());

            return true;
        } else {
            System.out.println("Transaction failed: " + customerName +
                    ", Insufficient balance, Time: " + LocalDateTime.now());
            return false;
        }
    }

    public int getBalance() {
        return balance;
    }
}

