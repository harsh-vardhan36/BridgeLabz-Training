package com.ewalletapplication;


class Main {

    public static void main(String[] args) {

        User Harsh = new User("Harsh36", "Harsh", new PersonalWallet(1000));

        User Alok = new User("Alok354", "Alok", new BusinessWallet(5000)
        );

        // User actions
        Harsh.loadMoney(2000);
        Alok.transferTo(Alok, 1200);

        System.out.println("\n===== WALLET SUMMARY =====\n");

        System.out.println("User : Harsh");
        System.out.println("Balance : ₹" + Harsh.checkBalance());
        Harsh.showTransactions();

        System.out.println();

        // Shop summary
        System.out.println("User : Alok");
        System.out.println("Balance : ₹" + Alok.checkBalance());
        Alok.showTransactions();
    }
}
