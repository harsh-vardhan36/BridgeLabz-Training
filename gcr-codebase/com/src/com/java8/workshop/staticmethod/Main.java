package com.java8.workshop.staticmethod;

public class Main {

    public static void main(String[] args) {

        Location busStop = new Location(28.6139, 77.2090);
        Location metroStation = new Location(28.7041, 77.1025);

        double distance = GeoUtils.calculateDistance(busStop, metroStation);

        System.out.println("Distance between locations: " + distance);
    }
}
