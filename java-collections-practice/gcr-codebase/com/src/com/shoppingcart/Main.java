package com.shoppingcart;

public class Main {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 55000);
        cart.addProduct("Mouse", 500);
        cart.addProduct("Keyboard", 1500);
        cart.addProduct("Monitor", 12000);

        System.out.println(" Cart (Insertion Order):");
        System.out.println(cart.viewCartInOrder());

        System.out.println("\n Cart (Sorted by Price):");
        System.out.println(cart.viewCartSortedByPrice());
    }
}
