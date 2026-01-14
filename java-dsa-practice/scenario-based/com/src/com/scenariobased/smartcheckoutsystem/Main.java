package com.scenariobased.smartcheckoutsystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SmartCheckout checkout = new SmartCheckout();

        
        checkout.addItem("Apple", 50, 10);
        checkout.addItem("Milk", 40, 5);
        checkout.addItem("Bread", 30, 2);

        
        checkout.addCustomer(new Customer("Harsh", Arrays.asList("Apple", "Milk")));
        checkout.addCustomer(new Customer("Riya", Arrays.asList("Bread", "Milk", "Apple")));

       
        checkout.processCheckout(); 
        checkout.processCheckout(); 
    }
}
