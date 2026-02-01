package com.java8.workshop.methodreferences;

import java.util.*;

public class SmartCityMethodReferenceApp {

    public static void main(String[] args) {

        List<TransportSchedule> services = Arrays.asList(
            new TransportSchedule("Bus", "Route 12", 30),
            new TransportSchedule("Metro", "Line A", 40),
            new TransportSchedule("Taxi", "Airport", 120)
        );

        //  Quick printing of services
        System.out.println("=== Available Services ===");
        services.forEach(System.out::println);   // method reference

        //  Logging using static method reference
        System.out.println("\n=== Logging Services ===");
        services.stream()
                .map(TransportSchedule::toString)
                .forEach(LoggerUtil::log);

        //  Static utility method for fare calculation
        System.out.println("\n=== Fare After Service Charge ===");
        services.stream()
                .map(TransportSchedule::getFare)
                .map(FareUtils::applyServiceCharge)
                .forEach(System.out::println);
    }
}
