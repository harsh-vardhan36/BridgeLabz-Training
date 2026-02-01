package com.java8.functional.unitconversion;

public interface UnitConverter {

    // km to miles
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    // kg to pounds
    static double kgToPounds(double kg) {
        return kg * 2.20462;
    }
}
