package com.objectmodelling.universitywithfaculties;

//Department class (Composition: part of University)
public class Department {
 private String deptName;

 public Department(String deptName) {
     this.deptName = deptName;
 }

 public void displayDepartment() {
     System.out.println("Department: " + deptName);
 }
}

