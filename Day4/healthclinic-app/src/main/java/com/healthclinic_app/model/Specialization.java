package com.healthclinic_app.model;

public class Specialization {
    private int spId;
    private String specialization;

   
    public Specialization() {}

  
    public Specialization(int spId, String specialization) {
        this.spId = spId;
        this.specialization = specialization;
    }

    // Getters and Setters
    
    public int getSpId() {
        return spId;
    }

    public void setSpId(int spId) {
        this.spId = spId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    
    @Override
    public String toString() {
        return "Specialization{" +
                "spId=" + spId +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
