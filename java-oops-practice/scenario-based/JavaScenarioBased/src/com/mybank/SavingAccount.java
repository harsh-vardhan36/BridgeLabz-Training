package com.mybank;

public class SavingAccount extends Account implements ITransaction {
    private final double interestRate = 4.0;

    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    public void withdraw(double amount) {
        if (amount <= getBalance())
            setBalance(getBalance() - amount);
    }

    public double checkBalance() {
        return getBalance();
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}
