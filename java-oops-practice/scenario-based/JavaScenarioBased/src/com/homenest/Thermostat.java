package com.homenest;

class Thermostat extends Device {
    public Thermostat(String id) {
        super(id, 4.0);
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("AC started");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("AC stopped");
    }

    public void reset() {
        System.out.println("Temperature reset to default");
    }
}
