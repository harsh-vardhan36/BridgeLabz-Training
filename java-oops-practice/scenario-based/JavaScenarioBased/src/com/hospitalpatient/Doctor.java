package com.hospitalpatient;

class Doctor {

    private String doctorName;
    private String specialization;

    public Doctor(String doctorName, String specialization) {
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("\nDoctor: " + doctorName);
        System.out.println("Specialization: " + specialization);
    }
}