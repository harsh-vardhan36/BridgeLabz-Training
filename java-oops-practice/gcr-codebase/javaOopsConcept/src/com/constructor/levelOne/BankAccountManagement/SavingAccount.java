package com.constructor.levelOne.BankAccountManagement;

public class SavingAccount extends BankAccount {
	public SavingsAccount(int accNo, String holder, double bal) {
        super(accNo, holder, bal);
    }

 public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);   // public → accessible
        System.out.println("Account Holder: " + accountHolder);   // protected → accessible
        System.out.println("Balance: " + getBalance());           // private → via method
    }
}
