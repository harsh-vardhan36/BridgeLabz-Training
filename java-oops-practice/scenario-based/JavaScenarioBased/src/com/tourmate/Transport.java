package com.tourmate;

public class Transport {
    private String type;
    private double cost;

    public Transport(String type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }
}

