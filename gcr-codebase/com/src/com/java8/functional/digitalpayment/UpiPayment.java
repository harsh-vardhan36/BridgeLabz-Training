package com.java8.functional.digitalpayment;

public class UpiPayment implements DigitalPayment {

    @Override
    public void pay() {
        System.out.println("Payment done using UPI");
    }
}
