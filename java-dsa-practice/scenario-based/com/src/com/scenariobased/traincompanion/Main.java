package com.scenariobased.traincompanion;

public class Main {
    public static void main(String[] args) {

        Train train = new Train();

        train.addCompartment("Sleeper");
        train.addCompartment("Pantry");
        train.addCompartment( "WiFi");
        train.addCompartment("AC");

        Compartment current = train.getHead(); 
        train.showNearby(current);
        train.moveForward(current);  

        current = current.next;
        train.showNearby(current);

        train.remove("WiFi");
    }
}
  