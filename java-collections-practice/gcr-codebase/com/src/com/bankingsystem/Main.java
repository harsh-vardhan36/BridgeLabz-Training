package com.bankingsystem;

public class Main {

    public static void main(String[] args) {

        BankingSystem bank = new BankingSystem();

        bank.addAccount(101, 5000);
        bank.addAccount(102, 12000);
        bank.addAccount(103, 8000);

        bank.requestWithdrawal(101);
        bank.requestWithdrawal(103);

        bank.processWithdrawal(2000);
        bank.processWithdrawal(9000);

        System.out.println("\n All Accounts:");
        System.out.println(bank.viewAccounts());

        System.out.println("\n Customers Sorted by Balance:");
        System.out.println(bank.getCustomersSortedByBalance());
    }
}
