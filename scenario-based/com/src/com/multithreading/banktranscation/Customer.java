package com.multithreading.banktranscation;

public class Customer extends Thread {

    private Bank bank;
    private int accountNumber;

    public Customer(String name, Bank bank, int accountNumber) {
        super(name);
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    @Override
    public void run() {

        // Customer transaction sequence
        bank.deposit(accountNumber, 500);
        bank.withdraw(accountNumber, 300);
        bank.withdraw(accountNumber, 700);
        bank.deposit(accountNumber, 1000);
    }
}
