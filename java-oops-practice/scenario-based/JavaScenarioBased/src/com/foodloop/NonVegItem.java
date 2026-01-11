package com.foodloop;

public class NonVegItem extends FoodItem {

    public NonVegItem(String name, double price, int stock) {
        super(name, "Non-Veg", price, stock);
    }

    @Override
    public double getDiscount() {
        return 0.05;   
    }
}
