package com.objectmodelling.bankaccount;

//Demonstration
public class BankMain{
 public static void main(String[] args) {
     // Create banks
     Bank bank1 = new Bank("State Bank");
     Bank bank2 = new Bank("National Bank");

     // Create customers
     Customer c1 = new Customer("Alice");
     Customer c2 = new Customer("Bob");

     // Open accounts
     Account a1 = bank1.openAccount(c1, 101);
     Account a2 = bank1.openAccount(c2, 102);
     Account a3 = bank2.openAccount(c1, 201); // Alice has accounts in two banks

     // Transactions
     a1.deposit(5000);
     a2.deposit(3000);
     a3.deposit(7000);

     // View balances
     c1.viewBalance();
     c2.viewBalance();
 }
}
