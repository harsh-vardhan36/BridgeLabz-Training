package com.homenest;

abstract class Device implements IControllable {

    protected String deviceId;
    private boolean status;              
    protected double energyUsage;        
    private String firmwareLog = "Secure Firmware v1.0";  

    public Device(String deviceId, double energyUsage) {
        this.deviceId = deviceId;
        this.energyUsage = energyUsage;
        this.status = false;
    }

    // Encapsulation
    public boolean isOn() {
        return status;
    }

    protected void setStatus(boolean value) {
        this.status = value;
    }

    public double calculateEnergy(int hours) {
        return energyUsage * hours;     
    }

    protected String getFirmwareLog() {
        return firmwareLog;
    }

    public abstract void reset();
}

