package com.objectmodelling.hospitalandpatients;

import java.util.ArrayList;
import java.util.List;

//Doctor class
public class Doctor {
 private String name;
 private List<Patient> patients;

 public Doctor(String name) {
     this.name = name;
     this.patients = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public void consult(Patient patient) {
     patients.add(patient);
     patient.addDoctor(this); // establish two-way association
     System.out.println("Dr. " + name + " is consulting patient " + patient.getName());
 }

 public List<Patient> getPatients() {
     return patients;
 }
}

