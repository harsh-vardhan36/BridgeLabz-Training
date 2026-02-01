package com.java8.stream.iotsensor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Sensor> sensors = List.of(
            new Sensor("S1", 45.6),
            new Sensor("S2", 72.3),
            new Sensor("S3", 30.1),
            new Sensor("S4", 85.9)
        );

        double threshold = 50.0;

        sensors.stream()
               .filter(sensor -> sensor.getReading() > threshold)
               .forEach(sensor ->
                   System.out.println(" High Reading: " + sensor)
               );
    }
}
