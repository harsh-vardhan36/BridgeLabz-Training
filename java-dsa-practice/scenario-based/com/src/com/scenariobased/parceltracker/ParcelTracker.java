package com.scenariobased.parceltracker;
class ParcelTracker {
    Stage head;

    void addStage(String stageName) {
        Stage newStage = new Stage(stageName);

        if (head == null) {
            head = newStage;
            return;
        }

        Stage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStage;
    }

    void addCheckpoint(String afterStage, String newStage) {
        Stage temp = head;

        while (temp != null && !temp.name.equals(afterStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found ");
            return;
        }

        Stage checkpoint = new Stage(newStage);
        checkpoint.next = temp.next;
        temp.next = checkpoint;
    }

    // Track parcel
    void trackParcel() {
        if (head == null) {
            System.out.println("Parcel lost (null pointer) ");
            return;
        }

        Stage temp = head;
        while (temp != null) {
            System.out.print(temp.name + " → ");
            temp = temp.next;
        }
        System.out.println("Delivered ");
    }
}
