package com.java8.workshop.interfaces;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<TransportService> services = Arrays.asList(
            new BusService("Route 12", 30),
            new MetroService("Line A", 40),
            new TaxiService("Airport Road", 120)
        );

        // Polymorphic behavior
        services.forEach(TransportService::printServiceDetails);
    }
}
