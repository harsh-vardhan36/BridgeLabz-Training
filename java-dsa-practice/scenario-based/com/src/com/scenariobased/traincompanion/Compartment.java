package com.scenariobased.traincompanion;

public class Compartment {
    String name;
    Compartment prev;
    Compartment next;

    public Compartment(String name) {
        this.name = name;
    }
}
