package com.hospitalpatient;

class InPatient extends Patient {

    private int daysAdmitted;

    // Normal admission
    public InPatient(int id, String name,  int age,  int daysAdmitted) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    // Emergency admission
    public InPatient(int id, String name, int age, String medicalHistory, int daysAdmitted) {
        super(id, name, age, medicalHistory);
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public void displayInfo() {
        System.out.println(" In-Patient \n Admitted For : " + daysAdmitted + " days");
    }
}