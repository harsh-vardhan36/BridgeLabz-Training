package com.swiftcart;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Product milk = new PerishableProduct("Milk", 50);
        Product rice = new NonPerishableProduct("Rice", 100);

        ArrayList<Product> list = new ArrayList<>();
        list.add(milk);
        list.add(rice);

        Cart cart = new Cart(list);
        cart.applyDiscount(10);
        cart.generateBill();
    }
}
