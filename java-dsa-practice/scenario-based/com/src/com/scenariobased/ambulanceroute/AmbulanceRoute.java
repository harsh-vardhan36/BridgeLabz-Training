package com.scenariobased.ambulanceroute;

class AmbulanceRoute {
    Unit head = null;

    void addUnit(String name) {
        Unit newUnit = new Unit(name);

        if (head == null) {
            head = newUnit;
            head.next = head;  
            return;
        }

        Unit temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newUnit;
        newUnit.next = head;
    }

   
    void removeUnit(String name) {
        if (head == null) return;

        Unit curr = head;
        Unit prev = null;

        do {
            if (curr.name.equals(name)) {
                if (curr == head) {
                    Unit last = head;
                    while (last.next != head)
                        last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println(name + " removed for maintenance");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    
    void sendPatient() {
        Unit temp = head;

        do {
            if (temp.available) {
                System.out.println("Patient sent to: " + temp.name);
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("No unit available!");
    }

    void setAvailability(String name, boolean status) {
        Unit temp = head;
        do {
            if (temp.name.equals(name)) {
                temp.available = status;
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }
}
