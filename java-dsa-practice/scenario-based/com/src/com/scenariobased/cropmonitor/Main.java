package com.scenariobased.cropmonitor;

public class Main {
    public static void main(String[] args) {

        int[] sensorTimestamps = { 1625, 1580, 1700, 1602, 1650, 1555 };

        SensorSorter monitor = new SensorSorter();

        System.out.println("Before sorting sensor data:");
        monitor.display(sensorTimestamps);

        monitor.quickSort(sensorTimestamps, 0, sensorTimestamps.length - 1);

        System.out.println("After sorting sensor data:");
        monitor.display(sensorTimestamps);
    }
}
