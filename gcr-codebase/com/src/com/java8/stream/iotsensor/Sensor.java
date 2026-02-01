package com.java8.stream.iotsensor;

class Sensor {
    String id;
    double reading;

    Sensor(String id, double reading) {
        this.id = id;
        this.reading = reading;
    }

    public double getReading() {
        return reading;
    }

    @Override
    public String toString() {
        return id + " → " + reading;
    }
}
