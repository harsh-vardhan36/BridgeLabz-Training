package com.ambulanceroute;

public class Main {
    public static void main(String[] args) {

        AmbulanceRoute route = new AmbulanceRoute();

        route.addUnit("Emergency");
        route.addUnit("Radiology");
        route.addUnit("Surgery");
        route.addUnit("ICU");

        route.setAvailability("Emergency", false);
        route.setAvailability("Radiology", false);

        route.sendPatient();   

        route.removeUnit("ICU");

        route.sendPatient();   
    }
}
