package com.healthclinic_app.model;

public class DoctorSpecialization {
    private int doctorId;
    private int spId;

    public DoctorSpecialization() {}

    public DoctorSpecialization(int doctorId, int spId) {
        this.doctorId = doctorId;
        this.spId = spId;
    }

    // Getters and Setters
    
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getSpId() {
        return spId;
    }

    public void setSpId(int spId) {
        this.spId = spId;
    }

    @Override
    public String toString() {
        return "DoctorSpecialization{" +
                "doctorId=" + doctorId +
                ", spId=" + spId +
                '}';
    }
}
