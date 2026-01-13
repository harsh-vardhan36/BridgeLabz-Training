package com.budgewise;
import java.util.*;

abstract class Budget implements IAnalyzable {

    protected double income;
    protected double limit;
    protected Map<String, Double> categoryLimits = new HashMap<>();
    protected List<Transaction> transactions = new ArrayList<>();

    public Budget(double income, double limit) {
        this.income = income;
        this.limit = limit;
    }

    public void addCategory(String name, double amount) {
        categoryLimits.put(name, amount);
    }

    // Encapsulation – expenses added only via method
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    protected double getTotalExpenses() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("expense")) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public double getNetSavings() {
        return income - getTotalExpenses();   // Operator usage
    }

    public boolean detectOverspend() {
        return getTotalExpenses() > limit;
    }

    public abstract void generateReport();
}
