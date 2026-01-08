package com.eventbase;

public class EventEaseApp {
    public static void main(String[] args) {

        User organizer = new User("Harsh", "harsh@email.com");

        Event event = new Event(
                "Tech Conference",
                "Delhi",
                "25-03-2026",
                organizer
        );

        event.addAttendee("Alice");
        event.addAttendee("Bob");
        event.addAttendee("Charlie");

        event.showEventDetails();
    }
}
