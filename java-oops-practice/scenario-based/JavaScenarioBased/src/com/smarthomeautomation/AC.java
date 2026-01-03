package com.smarthomeautomation;

class AC extends Appliance {

    private int temperature;

    public AC() {
        super("AC", 2000);
        this.temperature = 24;
    }

    @Override
    public void turnOn() {
        setPowerOn(true);
        System.out.println("AC turned ON at " + temperature + "°C");
    }

    @Override
    public void turnOff() {
        setPowerOn(false);
        System.out.println("AC turned OFF");
    }
}