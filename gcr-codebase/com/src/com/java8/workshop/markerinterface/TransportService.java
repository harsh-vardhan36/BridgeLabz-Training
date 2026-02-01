package com.java8.workshop.markerinterface;

public interface TransportService {

    String getServiceName();

    default void followTrafficRules() {
        System.out.println(getServiceName() + " follows normal traffic rules.");
    }
}

