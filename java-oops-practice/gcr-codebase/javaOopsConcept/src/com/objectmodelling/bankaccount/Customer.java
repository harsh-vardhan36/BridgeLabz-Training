package com.objectmodelling.bankaccount;

import java.util.ArrayList;
import java.util.List;

//Customer class
public class Customer {
 private String name;
 private List<Account> accounts;  // Association: Customer has multiple Accounts

 public Customer(String name) {
     this.name = name;
     this.accounts = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public void addAccount(Account account) {
     accounts.add(account);
 }

 // Method to view balance of all accounts
 public void viewBalance() {
     System.out.println("Customer: " + name);
     for (Account acc : accounts) {
         System.out.println("Account No: " + acc.getAccountNumber() +
                            " | Bank: " + acc.getBank().getName() +
                            " | Balance: " + acc.getBalance());
     }
 }
}
