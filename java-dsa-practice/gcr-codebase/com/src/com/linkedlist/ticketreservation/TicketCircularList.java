package com.linkedlist.ticketreservation;

public class TicketCircularList {
    private CNode head;
    private int count;

    public void addTicket(Ticket ticket) {
        CNode newNode = new CNode(ticket);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            count++;
            return;
        }

        CNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
        count++;
    }

    public void removeByTicketId(int ticketId) {
        if (head == null) return;

        if (head.data.ticketId == ticketId) {
            if (head.next == head) {
                head = null;
            } else {
                CNode temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            count--;
            return;
        }

        CNode curr = head;
        while (curr.next != head) {
            if (curr.next.data.ticketId == ticketId) {
                curr.next = curr.next.next;
                count--;
                return;
            }
            curr = curr.next;
        }
    }

    public void searchByCustomer(String customerName) {
        if (head == null) return;
        CNode temp = head;
        do {
            if (temp.data.customerName.equals(customerName)) {
                displayTicket(temp.data);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByMovie(String movieName) {
        if (head == null) return;
        CNode temp = head;
        do {
            if (temp.data.movieName.equals(movieName)) {
                displayTicket(temp.data);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }
        CNode temp = head;
        do {
            displayTicket(temp.data);
            temp = temp.next;
        } while (temp != head);
    }

    public int getTotalTickets() {
        return count;
    }

    private void displayTicket(Ticket t) {
        System.out.println(
            t.ticketId + " | " + t.customerName + " | " +
            t.movieName + " | " + t.seatNumber + " | " + t.bookingTime
        );
    }
}
