package com.queue.hospitaltriage;

public class Main {

    public static void main(String[] args) {

        HospitalTriage triage = new HospitalTriage();

        triage.addPatient(new Patient("John", 3));
        triage.addPatient(new Patient("Alice", 5));
        triage.addPatient(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        triage.treatPatients();
    }
}
