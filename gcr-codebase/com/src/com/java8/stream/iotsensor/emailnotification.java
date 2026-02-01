package com.java8.stream.iotsensor;

import java.util.List;

public class emailnotification {

    public static void main(String[] args) {

        List<String> emails = List.of(
            "user1@gmail.com",
            "user2@gmail.com",
            "user3@gmail.com"
        );

        emails.forEach(email -> sendEmailNotification(email));
    }

    static void sendEmailNotification(String email) {
        // Simulating email sending
        System.out.println("Notification sent to: " + email);
    }
}
