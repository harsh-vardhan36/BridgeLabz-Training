package com.java8.workshop.staticmethod;

public interface GeoUtils {

    // Static utility method inside interface
    static double calculateDistance(Location l1, Location l2) {

        double latDiff = l1.getLatitude() - l2.getLatitude();
        double lonDiff = l1.getLongitude() - l2.getLongitude();

        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }
}
