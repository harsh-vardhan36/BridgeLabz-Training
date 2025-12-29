package com.constructor.levelOne.BankAccountManagement;

public class BankAccount {
	public int accountNumber;
	protected String accountHolder;
	private double balance;
	
	BankAccount(int account, String name, double bal){
		accountNumber = account;
		accountHolder = name;
		balance = bal;
	}
	public void setBalace(double amount) {
          balance = amount;
	}
	public double getBalance() {
		return balance;
	}	
}
