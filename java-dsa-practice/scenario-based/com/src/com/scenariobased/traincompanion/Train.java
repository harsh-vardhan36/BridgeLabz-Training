package com.scenariobased.traincompanion;

public class Train {

    private Compartment head;
    private Compartment tail;

    // Add compartment at end
    public void addCompartment(String name) {
        Compartment newComp = new Compartment(name);

        if (head == null) {
            head = tail = newComp;
        } else {
            tail.next = newComp;
            newComp.prev = tail;
            tail = newComp;
        }
    }

    // Remove a compartment
    public void remove(String name) {
        Compartment temp = head;

        while (temp != null) {
            if (temp.name.equals(name)) {

                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
                else
                    tail = temp.prev;

                System.out.println(name + " removed");
                return;
            }
            temp = temp.next;
        }
    }

    // Move forward
    public void moveForward(Compartment current) {
        if (current.next != null)
            System.out.println("Now in: " + current.next.name);
        else
            System.out.println("You are in last compartment");
    }

    public void moveBackward(Compartment current) {
        if (current.prev != null)
            System.out.println("Now in: " + current.prev.name);
        else
            System.out.println("You are in first compartment");
    }

    // Display adjacent compartments
    public void showNearby(Compartment current) {
        System.out.print("Previous: ");
        if (current.prev != null) System.out.print(current.prev.name);
        else System.out.print("None");

        System.out.print(" | Current: " + current.name);

        System.out.print(" | Next: ");
        if (current.next != null) System.out.print(current.next.name);
        else System.out.print("None");

        System.out.println();
    }

    public Compartment getHead() {
        return head;
    }
}
