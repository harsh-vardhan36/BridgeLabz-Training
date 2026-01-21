package com.bankingsystem;

import java.util.*;

public class BankingSystem {

    private Map<Integer, Double> accounts = new HashMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    // Create account
    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    // Request withdrawal
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
        }
    }

    // Process withdrawal
    public void processWithdrawal(double amount) {

        if (withdrawalQueue.isEmpty()) {
            System.out.println("No withdrawal requests.");
            return;
        }

        int accountNumber = withdrawalQueue.poll();
        double balance = accounts.get(accountNumber);

        if (balance >= amount) {
            accounts.put(accountNumber, balance - amount);
            System.out.println("Withdrawal successful for account " + accountNumber);
        } else {
            System.out.println("Insufficient balance for account " + accountNumber);
        }
    }

    // Display customers sorted by balance
    public Map<Double, List<Integer>> getCustomersSortedByBalance() {

        Map<Double, List<Integer>> sortedMap = new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedMap
                .computeIfAbsent(entry.getValue(),
                                 b -> new ArrayList<>())
                .add(entry.getKey());
        }
        return sortedMap;
    }

    // View all accounts
    public Map<Integer, Double> viewAccounts() {
        return accounts;
    }
}
