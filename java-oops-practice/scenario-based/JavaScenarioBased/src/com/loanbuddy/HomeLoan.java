package com.loanbuddy;

class HomeLoan extends LoanApplication {

    public HomeLoan(Applicant applicant, int term) {
        super(applicant, term, 8.5); // default home loan rate
    }

    @Override
    public boolean approveLoan() {
        if (applicant.getCreditScore() >= 700 &&
            applicant.getIncome() >= 40000) {
            setApproved(true);
        }
        return isApproved();
    }

    @Override
    public double calculateEMI() {
        return emiFormula(
                applicant.getLoanAmount(),
                interestRate,
                term
        );
    }
}

