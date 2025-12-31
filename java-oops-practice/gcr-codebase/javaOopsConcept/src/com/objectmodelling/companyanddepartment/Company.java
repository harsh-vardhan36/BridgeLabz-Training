package com.objectmodelling.companyanddepartment;

import java.util.ArrayList;
import java.util.List;

//Company class (composed of Departments)
public class Company {
 private String companyName;
 private List<Department> departments;

 public Company(String companyName) {
     this.companyName = companyName;
     this.departments = new ArrayList<>();
 }

 public void addDepartment(Department dept) {
     departments.add(dept);
 }

 public void displayCompanyStructure() {
     System.out.println("Company: " + companyName);
     for (Department dept : departments) {
         dept.displayDepartment();
     }
 }

 // Simulate deletion of company
 public void deleteCompany() {
     System.out.println("Deleting company: " + companyName);
     departments.clear(); // removes all departments and employees
 }
}