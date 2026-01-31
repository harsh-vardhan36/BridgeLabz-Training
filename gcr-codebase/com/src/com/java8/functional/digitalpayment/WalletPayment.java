package com.java8.functional.digitalpayment;

public class WalletPayment implements DigitalPayment {

    @Override
    public void pay() {
        System.out.println("Payment done using Wallet");
    }
}
