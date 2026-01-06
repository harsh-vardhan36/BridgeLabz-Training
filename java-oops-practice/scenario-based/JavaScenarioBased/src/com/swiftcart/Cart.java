package com.swiftcart;

import java.util.ArrayList;

public class Cart implements ICheckout {
    private ArrayList<Product> products;
    private double totalPrice;

    public Cart() {
        products = new ArrayList<>();
    }

    public Cart(ArrayList<Product> products) {
        this.products = products;
        calculateTotal();
    }

    public void addProduct(Product product) {
        products.add(product);
        calculateTotal();
    }

    private void calculateTotal() {
        totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.getDiscountedPrice();
        }
    }

    @Override
    public void applyDiscount(double coupon) {
        totalPrice = totalPrice - coupon;
    }

    @Override
    public void generateBill() {
        System.out.println("Total Items: " + products.size());
        System.out.println("Payable Amount: " + totalPrice);
    }
}
