package com.linkedlist.ticketreservation;

public class Main {
    public static void main(String[] args) {

        TicketCircularList system = new TicketCircularList();

        system.addTicket(new Ticket(1, "Harsh", "Inception", "A1", "10:00 AM"));
        system.addTicket(new Ticket(2, "Rahul", "Avatar", "B2", "10:05 AM"));
        system.addTicket(new Ticket(3, "David", "Inception", "A2", "10:10 AM"));

        System.out.println("All Booked Tickets:");
        system.displayAll();

        System.out.println("\nSearch by Customer Harsh:");
        system.searchByCustomer("Harsh");

        System.out.println("\nSearch by Movie Inception:");
        system.searchByMovie("Inception");

        system.removeByTicketId(2);

        System.out.println("\nAfter Removing Ticket ID 2:");
        system.displayAll();

        System.out.println("\nTotal Tickets Booked:");
        System.out.println(system.getTotalTickets());
    }
}
