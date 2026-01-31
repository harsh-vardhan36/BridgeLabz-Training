package com.java8.functional.digitalpayment;

public class CreditCardPayment implements DigitalPayment {

    @Override
    public void pay() {
        System.out.println("Payment done using Credit Card");
    }
}
