package com.budgewise;

class MonthlyBudget extends Budget {

    public MonthlyBudget(double income, double limit) {
        super(income, limit);
    }

    public void generateReport() {
        System.out.println("📅 Monthly Budget Report");
        System.out.println("Income: " + income);
        System.out.println("Expenses: " + getTotalExpenses());
        System.out.println("Savings: " + getNetSavings());
    }
}
