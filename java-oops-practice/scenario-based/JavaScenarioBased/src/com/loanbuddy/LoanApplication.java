package com.loanbuddy;

abstract class LoanApplication implements IApprovable {

    protected Applicant applicant;
    protected int term; // in months
    protected double interestRate; // annual %

    private boolean approved; // 🔐 internal only

    public LoanApplication(Applicant applicant, int term, double interestRate) {
        this.applicant = applicant;
        this.term = term;
        this.interestRate = interestRate;
        this.approved = false;
    }

    protected void setApproved(boolean status) {
        this.approved = status;
    }

    public boolean isApproved() {
        return approved;
    }

    // Common EMI formula
    protected double emiFormula(double principal, double rate, int months) {
        double R = rate / (12 * 100); // monthly rate
        return (principal * R * Math.pow(1 + R, months)) /
               (Math.pow(1 + R, months) - 1);
    }
}
