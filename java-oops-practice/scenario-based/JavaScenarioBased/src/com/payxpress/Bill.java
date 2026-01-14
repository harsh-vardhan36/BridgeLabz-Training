package com.payxpress;
abstract class Bill implements IPayable {

    protected String type;
    protected double amount;
    protected String dueDate;
    private boolean isPaid;   
    public Bill(String type, double amount, String dueDate) {
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = false;
    }
    public double calculateLateFee(double penalty) {
        return amount + penalty;   
    }
    public void pay() {
        if (!isPaid) {
            isPaid = true;
            System.out.println(type + " bill paid successfully ");
        } else {
            System.out.println(type + " bill already paid ");
        }
    }

    protected boolean isPaid() {
        return isPaid;
    }
}
