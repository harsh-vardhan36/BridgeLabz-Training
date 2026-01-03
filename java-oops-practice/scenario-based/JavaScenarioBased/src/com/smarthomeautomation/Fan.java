package com.smarthomeautomation;

class Fan extends Appliance {

    private int speed;

    public Fan() {
        super("Fan", 120);
        this.speed = 3;
    }

    @Override
    public void turnOn() {
        setPowerOn(true);
        System.out.println("Fan turned ON at speed " + speed);
    }

    @Override
    public void turnOff() {
        setPowerOn(false);
        System.out.println("Fan turned OFF");
    }
}