package com.java8.functional.digitalpayment;

public class Main {
    public static void main(String[] args) {

        DigitalPayment upi = new UpiPayment();
        DigitalPayment card = new CreditCardPayment();
        DigitalPayment wallet = new WalletPayment();

        upi.pay();
        card.pay();
        wallet.pay();
    }
}
