package com.foodloop;

public class VegItem extends FoodItem {

    public VegItem(String name, double price, int stock) {
        super(name, "Veg", price, stock);
    }

    @Override
    public double getDiscount() {
        return 0.10;   
    }
}

