package com.foodloop;

import java.util.*;

public class Order implements IOrderable {

    private List<FoodItem> items;
    private double total;

    public Order(List<FoodItem> items) {
        this.items = items;
        calculateTotal();
    }

    private void calculateTotal() {
        double sum = 0;
        for (FoodItem item : items) {
            sum += item.getPrice();
        }

        double discount = applyDiscount(sum);
        total = sum - discount;
    }

    private double applyDiscount(double sum) {
        if (sum > 1000) return sum * 0.20;
        else if (sum > 500) return sum * 0.10;
        else return 0;
    }

    @Override
    public void placeOrder() {
        for (FoodItem item : items) {
            if (!item.isAvailable()) {
                System.out.println(item.name + " is out of stock!");
                return;
            }
        }

        for (FoodItem item : items) {
            item.reduceStock();
        }

        System.out.println("Order placed successfully!");
        System.out.println("Total bill: " + total);
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order cancelled.");
    }
}

