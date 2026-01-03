package com.smarthomeautomation;

class Main {

    public static void main(String[] args) {

        UserController user = new UserController("Harsh Vardhan");

        Appliance light = new Light();
        Appliance fan = new Fan();
        Appliance ac = new AC();

        user.controlOn(light);
        user.controlOn(fan);
        user.controlOn(ac);

        System.out.println();

        light.showStatus();
        fan.showStatus();
        ac.showStatus();

        System.out.println();
        
        user.showTotalPowerUsage(light, fan, ac);
        
        System.out.println();

        user.compareEnergyUsage(light, ac);
        user.compareEnergyUsage(fan, light);

        System.out.println();

        user.controlOff(ac);
        
        System.out.println();
        
        // Recalculate after turning AC off
        user.showTotalPowerUsage(light, fan, ac);
    }
}