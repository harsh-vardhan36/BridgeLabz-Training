package com.java8.functional.smartdevice;

public class Main {
    public static void main(String[] args) {

        SmartDevice light = new Light();
        SmartDevice ac = new AC();
        SmartDevice tv = new TV();

        light.turnOn();
        ac.turnOn();
        tv.turnOn();

        tv.turnOff();
        ac.turnOff();
        light.turnOff();
    }
}
