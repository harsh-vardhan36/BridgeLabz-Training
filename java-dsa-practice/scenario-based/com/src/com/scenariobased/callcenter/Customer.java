package com.scenariobased.callcenter;

public class Customer {
    private int id;
    private String name;
    private boolean isVIP;

    public Customer(int id, String name, boolean isVIP) {
        this.id = id;
        this.name = name;
        this.isVIP = isVIP;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isVIP() {
        return isVIP;
    }
}
