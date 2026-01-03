package com.ewalletapplication;

class User implements Transferrable {

    private String userId;
    private String name;
    private Wallet wallet;

    public User(String userId, String name, Wallet wallet) {
        this.userId = userId;
        this.name = name;
        this.wallet = wallet;
    }

    public double checkBalance() {
        return wallet.getBalance();
    }

    public void loadMoney(double amount) {
        wallet.credit(
            amount,
            "Load Money by UserID: " + userId
        );
        System.out.println(name + " (" + userId + ") loaded ₹" + amount);
    }

    @Override
    public void transferTo(User receiver, double amount) {

        if (amount > wallet.getTransferLimit()) {
            System.out.println("Transfer failed for " + userId +
                    ": Limit exceeded");
            return;
        }

        double tax = amount * 0.02;
        double total = amount + tax;

        boolean success = wallet.deduct(
            total,
            "Transfer to " + receiver.userId
        );

        if (success) {
            receiver.wallet.credit(
                amount,
                "Received from " + userId
            );

            System.out.println("₹" + amount + " transferred from "
                    + name + " (" + userId + ") to "
                    + receiver.name + " (" + receiver.userId + ")");
            System.out.println("Service Fee: ₹" + tax);
        } else {
            System.out.println("Transfer failed for " + userId +
                    ": Insufficient balance");
        }
    }

    public void showTransactions() {
        System.out.println("User: " + name + " (" + userId + ")");
        wallet.printTransactionHistory();
    }
}
