package com.budgewise;

class AnnualBudget extends Budget {

    public AnnualBudget(double income, double limit) {
        super(income, limit);
    }

    public void generateReport() {
        System.out.println("📊 Annual Budget Report");
        System.out.println("Yearly Income: " + income);
        System.out.println("Yearly Expenses: " + getTotalExpenses());
        System.out.println("Yearly Savings: " + getNetSavings());
    }
}
