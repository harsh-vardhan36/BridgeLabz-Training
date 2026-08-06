package com.healthclinic_app.model;

public class DoctorRevenueReport {
    private int doctorId;
    private String doctorName;
    private int totalAppointments;
    private double totalBilled;
    private double totalCollected;

    public DoctorRevenueReport() {}

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getTotalAppointments() {
        return totalAppointments;
    }

    public void setTotalAppointments(int totalAppointments) {
        this.totalAppointments = totalAppointments;
    }

    public double getTotalBilled() {
        return totalBilled;
    }

    public void setTotalBilled(double totalBilled) {
        this.totalBilled = totalBilled;
    }

    public double getTotalCollected() {
        return totalCollected;
    }

    public void setTotalCollected(double totalCollected) {
        this.totalCollected = totalCollected;
    }

    @Override
    public String toString() {
        return "DoctorRevenueReport{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", totalAppointments=" + totalAppointments +
                ", totalBilled=" + totalBilled +
                ", totalCollected=" + totalCollected +
                '}';
    }
}
