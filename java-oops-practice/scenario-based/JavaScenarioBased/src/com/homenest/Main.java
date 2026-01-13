package com.homenest;

public class Main {
    public static void main(String[] args) {

        Device d1 = new Light("L101");
        Device d2 = new Camera("C202");
        Device d3 = new Thermostat("T303");

        d1.turnOn();
        d2.turnOn();
        d3.turnOn();

        System.out.println("Energy used by Light for 3 hrs = " + d1.calculateEnergy(3));

        d1.reset();   // Light reset
        d2.reset();   // Camera reset
        d3.reset();   // Thermostat reset
    }
}
