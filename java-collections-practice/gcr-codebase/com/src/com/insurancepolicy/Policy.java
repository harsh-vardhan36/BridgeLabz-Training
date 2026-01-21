package com.insurancepolicy;

import java.time.LocalDate;

public class Policy {

    private int policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(int policyNumber, String policyHolderName,
                  LocalDate expiryDate, String coverageType,
                  double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyHolderName +
               " | Exp: " + expiryDate +
               " | " + coverageType +
               " | ₹" + premiumAmount;
    }
}
