package com.foodloop;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	String dish;
    	System.out.println("Please Enter your NonVeg Dish: ");
    	 dish = input.nextLine();
        FoodItem burger = new NonVegItem(dish, 300, 5);
        FoodItem pizza = new VegItem("Veg Pizza", 400, 5);
        FoodItem pasta = new VegItem("White Sauce Pasta", 350, 5);

        List<FoodItem> combo = new ArrayList<>();
        combo.add(burger);
        combo.add(pizza);
        combo.add(pasta);

        Order order = new Order(combo);
        order.placeOrder();
    }
}

