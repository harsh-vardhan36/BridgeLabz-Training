package com.constructor.levelOne.BankAccountManagement;

public class BankMain {
	public static void main(String[] args) {
	    BankAccount bankAccount = new BankAccount(123456, "Alice Smith", 5000.0);
        System.out.println("Bank Account Balance: " + bankAccount.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount(654321, "Bob Johnson", 10000.0);
        savingsAccount.displayDetails();
	}
}
