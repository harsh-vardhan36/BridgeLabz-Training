package com.scenariobased.eventmanager;
public class Main {
    public static void main(String[] args) {

        Ticket[] tickets = {
            new Ticket(1200),
            new Ticket(500),
            new Ticket(3000),
            new Ticket(800),
            new Ticket(1500)
        };

        EventManager manager = new EventManager();
        manager.quickSort(tickets, 0, tickets.length - 1);

        System.out.println("Top 3 Cheapest Tickets:");
        manager.displayTopCheapest(tickets, 3);
    }
}
