package com.tourmate;

public class Activity {
    private String name;
    private double cost;

    public Activity(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}

