package com.java8.stream.eventattendee;

import java.util.List;

public class EventWelcome {
    public static void main(String[] args) {

        List<String> attendees = List.of(
            "Amit",
            "Riya",
            "Karan",
            "Sneha"
        );

        attendees.stream()
                 .forEach(name -> 
                     System.out.println("Welcome to the event, " + name + "!")
                 );
    }
}
