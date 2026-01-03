package com.smarthomeautomation;

class UserController {

    private String userName;

    public UserController(String userName) {
        this.userName = userName;
    }

    public void controlOn(Appliance appliance) {
        System.out.println(userName + " is turning ON " + appliance.getName());
        appliance.turnOn();
    }

    public void controlOff(Appliance appliance) {
        System.out.println(userName + " is turning OFF " + appliance.getName());
        appliance.turnOff();
    }
    
    public void showTotalPowerUsage(Appliance... appliances) {

        int total = 0;

        for (Appliance appliance : appliances) {
            if (appliance.isPowerOn()) {
                total += appliance.getPowerConsumption();
            }
        }

        System.out.println("Total Power Usage (Active Devices): " + total + "W");
    }


    public void compareEnergyUsage(Appliance a1, Appliance a2) {

        if (a1.getPowerConsumption() > a2.getPowerConsumption()) {
            System.out.println(a1.getName() + " consumes more energy than " + a2.getName());
        } else if (a1.getPowerConsumption() < a2.getPowerConsumption()) {
            System.out.println(a2.getName() + " consumes more energy than " + a1.getName());
        } else {
            System.out.println(a1.getName() + " and " + a2.getName() + " consume equal energy");
        }
    }
}
