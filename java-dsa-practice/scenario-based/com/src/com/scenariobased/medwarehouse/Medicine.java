package com.scenariobased.medwarehouse;

public class Medicine {
    String name;
    int expiryDays; // days remaining to expire

    public Medicine(String name, int expiryDays) {
        this.name = name;
        this.expiryDays = expiryDays;
    }
}
