package com.tourmate;

import java.util.List;

public class InternationalTrip extends Trip implements IBookable {

    public InternationalTrip(String destination, int duration, Hotel hotel, Transport transport, List<Activity> activities) {
        super(destination, duration, hotel, transport, activities);
    }

    @Override
    public void book() {
        System.out.println("International trip to " + destination + " booked.");
        System.out.println("Passport, visa, insurance and international payment verified.");
    }

    @Override
    public void cancel() {
        System.out.println("International trip to " + destination + " cancelled with refund process.");
    }
}

