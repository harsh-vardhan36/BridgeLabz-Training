
 package com.healthclinic_app.model;

 import java.sql.Timestamp;

 public class Doctor {
     private int doctorId;
     private String name;
     private String phone;
     private String email;
     private int experienceYears;
     private double fees;
     private Timestamp joinedAt;

     public Doctor() {}
     
     public Doctor(int doctorId, String name, String phone, String email,
                   int experienceYears, double fees, Timestamp joinedAt) {
         this.doctorId = doctorId;
         this.name = name;
         this.phone = phone;
         this.email = email;
         this.experienceYears = experienceYears;
         this.fees = fees;
         this.joinedAt = joinedAt;
     }

     public int getDoctorId() {
         return doctorId;
     }

     public void setDoctorId(int doctorId) {
         this.doctorId = doctorId;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getPhone() {
         return phone;
     }

     public void setPhone(String phone) {
         this.phone = phone;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public int getExperienceYears() {
         return experienceYears;
     }

     public void setExperienceYears(int experienceYears) {
         this.experienceYears = experienceYears;
     }

     public double getFees() {
         return fees;
     }

     public void setFees(double fees) {
         this.fees = fees;
     }

     public Timestamp getJoinedAt() {
         return joinedAt;
     }

     public void setJoinedAt(Timestamp joinedAt) {
         this.joinedAt = joinedAt;
     }

     // toString method for CLI display
     @Override
     public String toString() {
         return "Doctor{" +
                 "doctorId=" + doctorId +
                 ", name='" + name + '\'' +
                 ", phone='" + phone + '\'' +
                 ", email='" + email + '\'' +
                 ", experienceYears=" + experienceYears +
                 ", fees=" + fees +
                 ", joinedAt=" + joinedAt +
                 '}';
     }
}
