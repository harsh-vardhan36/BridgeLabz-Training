package com.smarthomeautomation;

class Light extends Appliance {

    public Light() {
        super("Light", 60); // default power
    }

    @Override
    public void turnOn() {
        setPowerOn(true);
        System.out.println("Light turned ON (Warm brightness)");
    }

    @Override
    public void turnOff() {
        setPowerOn(false);
        System.out.println("Light turned OFF");
    }
}