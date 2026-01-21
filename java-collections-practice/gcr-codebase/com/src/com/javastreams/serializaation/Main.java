package com.javastreams.serializaation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String fileName = "employees.dat";

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Harsh", "IT", 50000));
        employees.add(new Employee(102, "Aman", "HR", 45000));
        employees.add(new Employee(103, "Riya", "Finance", 55000));

        // Save employees
        EmployeeFileUtil.saveEmployees(employees, fileName);

        // Retrieve employees
        EmployeeFileUtil.readEmployees(fileName);
    }
}
