package com.scenariobased.hospitalqueue;

public class Main {
    public static void main(String[] args) {

        Patient[] patients = {
            new Patient("Amit", 3),
            new Patient("Riya", 8),
            new Patient("John", 5),
            new Patient("Neha", 9)
        };

        HospitalQueue queue = new HospitalQueue();
        queue.sortByCriticality(patients);
        queue.display(patients);
    }
}
