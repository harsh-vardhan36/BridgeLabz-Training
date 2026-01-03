package com.hospitalpatient;

/* 1. Hospital Patient Management System
Scenario: A hospital wants a software module to register patients, assign doctors, and maintain billing.
*/
abstract class Patient {

    private int patientId;
    private String name;
    private int age;
    private String medicalHistory; //sensitive data so kept private

    //constructor for Normal admission
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    //Constructor for Emergency admission
    public Patient(int patientId, String name, int age,  String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    //using getSummary() to show the details.
    public String getSummary() {
        String historyStatus =
                (medicalHistory == null) ? "Not Provided" : "Available (Secured)";
        return " Patient ID: " + patientId +
               "\n Name: " + name +
       		   "\n Age: " + age +
               "\n Medical History: " + historyStatus;
    }

    public abstract void displayInfo();
}