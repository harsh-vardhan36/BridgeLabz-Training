package com.tourmate;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel("Grand Palace", 15000);
        Transport transport = new Transport("Flight", 12000);

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("City Tour", 2000));
        activities.add(new Activity("Adventure Park", 3000));

        Trip trip = new InternationalTrip("Paris", 7, hotel, transport, activities);

        trip.showSummary();

        IBookable booking = (IBookable) trip;
        booking.book();
        booking.cancel();
    }
}
