package com.healthclinic_app.model;

import java.sql.Timestamp;

public class Bill {
    private int billId;
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private double amount;
    private String status;      // UNPAID, PAID, CANCELLED
    private Timestamp generatedAt;
    private Timestamp paidAt;

    public Bill() {}

    public Bill(int billId, int appointmentId, int patientId, int doctorId,
                double amount, String status, Timestamp generatedAt, Timestamp paidAt) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.amount = amount;
        this.status = status;
        this.generatedAt = generatedAt;
        this.paidAt = paidAt;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Timestamp generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Timestamp getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Timestamp paidAt) {
        this.paidAt = paidAt;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", generatedAt=" + generatedAt +
                ", paidAt=" + paidAt +
                '}';
    }
}
