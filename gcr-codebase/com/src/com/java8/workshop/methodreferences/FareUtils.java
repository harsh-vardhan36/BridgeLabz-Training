package com.java8.workshop.methodreferences;

public class FareUtils {

    public static double applyServiceCharge(double fare) {
        return fare + (fare * 0.10); // 10% service charge
    }
}
