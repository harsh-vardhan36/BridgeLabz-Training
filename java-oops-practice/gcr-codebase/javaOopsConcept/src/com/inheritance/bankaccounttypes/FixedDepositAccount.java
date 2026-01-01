package com.inheritance.bankaccounttypes;

public class FixedDepositAccount extends BankAccount {
 
	// in months
    private int tenure; 

    public FixedDepositAccount(String accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Tenure: " + tenure + " months");
    }
}