package com.scenariobased.trafficmanager;

public class Car {
    private String number;
    Car next;

    public Car(String number) {
        this.number = number;
        this.next = null;
    }

    public String getNumber() {
        return number;
    }
}
