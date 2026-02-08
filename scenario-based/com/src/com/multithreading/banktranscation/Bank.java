package com.multithreading.banktranscation;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    // Stores account balances
    private Map<Integer, Integer> accounts = new HashMap<>();

    // Stores locks for each account (important for per-account synchronization)
    private Map<Integer, Object> accountLocks = new HashMap<>();

    // Create account
    public void addAccount(int accountNumber, int initialBalance) {
        accounts.put(accountNumber, initialBalance);
        accountLocks.put(accountNumber, new Object());
    }

    // Deposit method (Thread-safe)
    public void deposit(int accountNumber, int amount) {

        synchronized (accountLocks.get(accountNumber)) {

            int currentBalance = accounts.get(accountNumber);

            System.out.println(Thread.currentThread().getName() +
                    " depositing ₹" + amount + " into Account " + accountNumber);

            accounts.put(accountNumber, currentBalance + amount);

            System.out.println("Updated Balance: ₹" + accounts.get(accountNumber));
        }
    }

    // Withdraw method (Thread-safe)
    public void withdraw(int accountNumber, int amount) {

        synchronized (accountLocks.get(accountNumber)) {

            int currentBalance = accounts.get(accountNumber);

            System.out.println(Thread.currentThread().getName() +
                    " withdrawing ₹" + amount + " from Account " + accountNumber);

            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
                //code by harshvardhan46
                System.out.println("Withdrawal Successful...");
            } else {
                System.out.println("Withdrawal Failed ! \t Insufficient Balance");
            }

            System.out.println("Updated Balance: ₹" + accounts.get(accountNumber));
        }
    }

    // Get Balance (Thread-safe read)
    public int getBalance(int accountNumber) {

        synchronized (accountLocks.get(accountNumber)) {
            return accounts.get(accountNumber);
        }
    }
}
