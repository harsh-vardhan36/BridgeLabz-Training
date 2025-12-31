package com.objectmodelling.bankaccount;

import java.util.ArrayList;
import java.util.List;

//Bank class
public class Bank {
 private String name;
 private List<Customer> customers;  // Association: Bank has Customers

 public Bank(String name) {
     this.name = name;
     this.customers = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public void addCustomer(Customer customer) {
     customers.add(customer);
 }

 // Method to open account for a customer
 public Account openAccount(Customer customer, int accountNumber) {
     Account newAccount = new Account(accountNumber, this);
     customer.addAccount(newAccount);
     if (!customers.contains(customer)) {
         customers.add(customer);
     }
     System.out.println("Account " + accountNumber + " opened for " + customer.getName() + " in " + name);
     return newAccount;
 }
}
