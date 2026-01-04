package com.mybank;

public class CurrentAccount extends Account implements ITransaction {
    private final double interestRate = 2.0;

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
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
