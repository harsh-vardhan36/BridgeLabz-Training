package com.smarthomeautomation;

abstract class Appliance implements Controllable {

    private boolean powerOn;
    private int powerConsumption; 
    private String name;

    protected Appliance(String name, int powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
    }

    protected void setPowerOn(boolean state) {
        this.powerOn = state;
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public String getName() {
        return name;
    }

    public void showStatus() {
        System.out.println(
            name + " is " + (powerOn ? "ON" : "OFF") +
            " | Power Usage: " + powerConsumption + "W"
        );
    }
}