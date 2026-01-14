package com.scenariobased.parceltracker;

public class Main {
    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        tracker.addCheckpoint("Shipped", "Custom Checkpoint");

        tracker.trackParcel();
    }
}
