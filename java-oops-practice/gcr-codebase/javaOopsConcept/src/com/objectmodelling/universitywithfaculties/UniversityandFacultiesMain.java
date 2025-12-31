package com.objectmodelling.universitywithfaculties;

//Demonstration
public class UniversityandFacultiesMain {
 public static void main(String[] args) {
     // Create University
     University uni = new University("National Institute of Technology");

     // Create Departments (Composition)
     Department csDept = new Department("Computer Science");
     Department mechDept = new Department("Mechanical Engineering");

     // Create Faculties (Aggregation)
     Faculty f1 = new Faculty("Dr. Alice", "Artificial Intelligence");
     Faculty f2 = new Faculty("Dr. Bob", "Thermodynamics");

     // Add to University
     uni.addDepartment(csDept);
     uni.addDepartment(mechDept);

     uni.addFaculty(f1);
     uni.addFaculty(f2);

     // Display structure
     uni.displayUniversity();

     // Delete University
     uni.deleteUniversity();

     // Faculties can still exist independently
     System.out.println("\nIndependent Faculty Members:");
     f1.displayFaculty();
     f2.displayFaculty();
 }
}
