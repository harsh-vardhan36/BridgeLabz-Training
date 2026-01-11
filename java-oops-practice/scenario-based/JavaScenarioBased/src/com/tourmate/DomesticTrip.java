package com.tourmate;

import java.util.List;

public class DomesticTrip extends Trip implements IBookable {

    public DomesticTrip(String destination, int duration, Hotel hotel, Transport transport, List<Activity> activities) {
        super(destination, duration, hotel, transport, activities);
    }

    @Override
    public void book() {
        System.out.println("Domestic trip to " + destination + " booked successfully.");
    }

    @Override
    public void cancel() {
        System.out.println("Domestic trip to " + destination + " cancelled.");
    }
}
