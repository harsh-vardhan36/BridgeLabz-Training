package com.multithreading.banktranscation;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        // Create accounts
        bank.addAccount(101, 1000);
        bank.addAccount(102, 2000);

        System.out.println("=== Bank Simulation Started ===\n");

        // Create multiple customers (threads)
        Customer c1 = new Customer("Customer-1", bank, 101);
        Customer c2 = new Customer("Customer-2", bank, 101);
        Customer c3 = new Customer("Customer-3", bank, 102);

        // Start threads
        c1.start();
        c2.start();
        c3.start();

        // Wait for all customers to finish
        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        // Final balances
        System.out.println("\n=== Final Account Balances ===");
        System.out.println("Account 101 Balance: ₹" + bank.getBalance(101));
        System.out.println("Account 102 Balance: ₹" + bank.getBalance(102));

        System.out.println("\n=== Bank Simulation Completed ===");
    }
}
