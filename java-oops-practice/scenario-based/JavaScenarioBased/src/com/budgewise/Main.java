package com.budgewise;

public class Main {
    public static void main(String[] args) {

        Budget budget = new MonthlyBudget(50000, 30000);  

        budget.addTransaction(new Transaction(10000, "expense", "10-Jan", "Food"));
        budget.addTransaction(new Transaction(8000, "expense", "15-Jan", "Rent"));
        budget.addTransaction(new Transaction(2000, "expense", "18-Jan", "Travel"));

        budget.generateReport();

        if (budget.detectOverspend()) {
            System.out.println(" You have overspent!");
        } else {
            System.out.println(" Budget under control");
        }
    }
}
