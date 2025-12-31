package com.objectmodelling.companyanddepartment;

import java.util.ArrayList;
import java.util.List;

//Department class (part of Company)
public class Department {
 private String deptName;
 private List<Employee> employees;

 public Department(String deptName) {
     this.deptName = deptName;
     this.employees = new ArrayList<>();
 }

 public void addEmployee(String name, String role) {
     employees.add(new Employee(name, role));
 }

 public void displayDepartment() {
     System.out.println("Department: " + deptName);
     for (Employee emp : employees) {
         emp.displayEmployee();
     }
 }
}
