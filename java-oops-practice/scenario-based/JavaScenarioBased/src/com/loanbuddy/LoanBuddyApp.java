package com.loanbuddy;

public class LoanBuddyApp {
    public static void main(String[] args) {

        Applicant applicant = new Applicant(
                "Harsh",
                720,
                60000,
                500000
        );

        LoanApplication loan = new HomeLoan(applicant, 240);

        if (loan.approveLoan()) {
            System.out.println(" Loan Approved!");
            System.out.println("Monthly EMI: ₹" +
                    Math.round(loan.calculateEMI()));
        } else {
            System.out.println(" Loan Rejected!");
        }
    }
}
