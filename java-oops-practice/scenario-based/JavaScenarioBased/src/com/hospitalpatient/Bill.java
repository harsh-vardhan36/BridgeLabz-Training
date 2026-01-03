package com.hospitalpatient;

class Bill implements Payable {

    private double baseAmount;
    private double taxRate;
    private double discount;

    public Bill(double baseAmount, double taxRate, double discount) {
        this.baseAmount = baseAmount;
        this.taxRate = taxRate;
        this.discount = discount;
    }

    @Override
    public double calculatePayment() {
        double tax = baseAmount * taxRate;
        return baseAmount + tax - discount;
    }
}