package com.java8.workshop.markerinterface;

public class TrafficControlSystem {

    public static void applyTrafficRules(TransportService service) {

        if (service instanceof EmergencyService) {
            System.out.println(service.getServiceName()
                    + " can bypass traffic signals");
        } else {
            service.followTrafficRules();
        }
    }

    public static void main(String[] args) {

        TransportService ambulance = new AmbulanceService();
        TransportService fireTruck = new FireService();
        TransportService bus = new BusService();

        applyTrafficRules(ambulance);
        applyTrafficRules(fireTruck);
        applyTrafficRules(bus);
    }
}
