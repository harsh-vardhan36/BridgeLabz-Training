package com.ewalletapplication;
class PersonalWallet extends Wallet {

    public PersonalWallet(double initialBalance) {
        super(initialBalance + 50); 
        transactions.add(new Transaction("Referral Bonus", 50));
    }

    @Override
    public double getTransferLimit() {
        return 50000;
    }
}