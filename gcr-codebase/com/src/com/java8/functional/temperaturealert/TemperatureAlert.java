package com.java8.functional.temperaturealert;

import java.util.function.Predicate;

public class TemperatureAlert {

    public static void main(String[] args) {

        double threshold = 37.5;

        Predicate<Double> isHighTemperature =
                temp -> temp > threshold;

        double currentTemp = 38.2;

        if (isHighTemperature.test(currentTemp)) {
            System.out.println(" Alert! High temperature detected: " + currentTemp);
        } else {
            System.out.println("Temperature is normal: " + currentTemp);
        }
    }
}
