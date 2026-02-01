package com.java8.stream.insuranceclain;

class Claim {
    String claimType;
    double amount;

    Claim(String claimType, double amount) {
        this.claimType = claimType;
        this.amount = amount;
    }

    public String getClaimType() {
        return claimType;
    }

    public double getAmount() {
        return amount;
    }
}
