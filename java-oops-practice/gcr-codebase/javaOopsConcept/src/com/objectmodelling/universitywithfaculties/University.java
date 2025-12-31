package com.objectmodelling.universitywithfaculties;

import java.util.ArrayList;
import java.util.List;

//University class (Composed of Departments, Aggregates Faculties)
public class University {
 private String universityName;
 private List<Department> departments;
 private List<Faculty> faculties;

 public University(String universityName) {
     this.universityName = universityName;
     this.departments = new ArrayList<>();
     this.faculties = new ArrayList<>();
 }

 // Add Department (Composition)
 public void addDepartment(Department dept) {
     departments.add(dept);
 }

 // Add Faculty (Aggregation)
 public void addFaculty(Faculty faculty) {
     faculties.add(faculty);
 }

 // Display University structure
 public void displayUniversity() {
     System.out.println("University: " + universityName);

     System.out.println("Departments:");
     for (Department dept : departments) {
         dept.displayDepartment();
     }

     System.out.println("Faculties:");
     for (Faculty faculty : faculties) {
         faculty.displayFaculty();
     }
 }

 // Delete University (Composition ensures departments are deleted too)
 public void deleteUniversity() {
     System.out.println("Deleting University: " + universityName);
     departments.clear(); // Departments vanish with University
     faculties.clear();   // Faculties association removed, but they can exist independently elsewhere
 }
}
