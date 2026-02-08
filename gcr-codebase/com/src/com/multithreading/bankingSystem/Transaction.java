package com.multithreading.bankingSystem;

public class Transaction implements Runnable {

    private BankAccount account;
    private int amount;

    public Transaction(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(Thread.currentThread().getName(), amount);
    }
}

