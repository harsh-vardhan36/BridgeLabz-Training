package com.java8.workshop.defaultmethod;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<TransportService> services = Arrays.asList(
            new BusService("Route 12"),
            new MetroService("Line A"),
            new TaxiService("Airport Road")
        );

        // Default method used for all transport types
        services.forEach(TransportService::printServiceDetails);
    }
}
