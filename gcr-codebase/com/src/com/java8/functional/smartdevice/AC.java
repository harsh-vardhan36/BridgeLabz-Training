package com.java8.functional.smartdevice;

public class AC implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("AC is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("AC is OFF");
    }
}
