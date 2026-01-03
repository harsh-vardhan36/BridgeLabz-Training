package com.hospitalpatient;

class Main {

    public static void main(String[] args) {

        Patient p1 = new InPatient(101, "Alok", 21, 5);
        Patient p2 = new Outpatient(102, "Saurav", 12,  10);
        Patient p3 = new InPatient(103, "Raghav", 21,  "Typhoid, Malaria", 10);

        Doctor d1 = new Doctor("Dr. Harsh Vardhan", "Neurologist");
        Bill bill = new Bill(20000, 0.10, 2000);

        System.out.println("\n" + p1.getSummary());
        p1.displayInfo();

        System.out.println("\n" + p2.getSummary());
        p2.displayInfo();
        
        System.out.println("\n" + p3.getSummary());
        p3.displayInfo();

        d1.displayInfo();

        System.out.println("Final Bill Amount: ₹" + bill.calculatePayment());
    }
}