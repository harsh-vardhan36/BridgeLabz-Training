package com.mybank;

public class Main {
    public static void main(String[] args) {
        Account acc1 = new SavingAccount("SB101", 10000);
        Account acc2 = new CurrentAccount("CA201");

        ITransaction t1 = (ITransaction) acc1;
        t1.deposit(2000);

        ITransaction t2 = (ITransaction) acc2;
        t2.deposit(5000);

        System.out.println("Savings Balance: " + t1.checkBalance());
        System.out.println("Savings Interest: " + acc1.calculateInterest());

        System.out.println("Current Balance: " + t2.checkBalance());
        System.out.println("Current Interest: " + acc2.calculateInterest());
    }
}

