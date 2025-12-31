package com.objectmodelling.hospitalandpatients;

import java.util.ArrayList;
import java.util.List;

//Patient class
public class Patient {
 private String name;
 private List<Doctor> doctors;

 public Patient(String name) {
     this.name = name;
     this.doctors = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public void addDoctor(Doctor doctor) {
     doctors.add(doctor);
 }

 public List<Doctor> getDoctors() {
     return doctors;
 }
}