package com.eventbase;

import java.util.ArrayList;

class Event {
    private String eventName;
    private String location;
    private String date;
    private ArrayList<String> attendees;
    private User organizer;

    public Event(String eventName, String location, String date, User organizer) {
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.organizer = organizer;
        this.attendees = new ArrayList<>();
    }

    public void addAttendee(String name) {
        attendees.add(name);
    }

    public void showEventDetails() {
        System.out.println("\n--- EVENT DETAILS ---");
        System.out.println("Event     : " + eventName);
        System.out.println("Location  : " + location);
        System.out.println("Date      : " + date);
        System.out.println("Organizer : " + organizer.getName());
        System.out.println("Attendees : " + attendees.size());
    }
}
