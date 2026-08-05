package com.healthclinic_app.model;

public class DoctorStats {
    private int doctorId;
    private int totalPatients;
    
    public DoctorStats() {}

    public DoctorStats(int doctorId, int totalPatients) {
        this.doctorId = doctorId;
        this.totalPatients = totalPatients;
    }

    // Getters and Setters
    
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(int totalPatients) {
        this.totalPatients = totalPatients;
    }

    @Override
    public String toString() {
        return "DoctorStats{" +
                "doctorId=" + doctorId +
                ", totalPatients=" + totalPatients +
                '}';
    }
}
