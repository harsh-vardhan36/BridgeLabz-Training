package com.scenariobased.trafficmanager;

public class Main {
    public static void main(String[] args) {

        TrafficManager tm = new TrafficManager(3);

        tm.addCar("CAR1");
        tm.addCar("CAR2");
        tm.addCar("CAR3");
        tm.addCar("CAR4");   

        tm.printRoundabout();

        tm.removeCar("CAR2");  
        tm.printRoundabout();
    }
}
