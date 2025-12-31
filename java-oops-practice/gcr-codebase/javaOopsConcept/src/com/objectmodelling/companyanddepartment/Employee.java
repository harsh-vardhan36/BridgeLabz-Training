package com.objectmodelling.companyanddepartment;

import java.util.ArrayList;
import java.util.List;

// Employee class
public class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void displayEmployee() {
        System.out.println("Employee: " + name + " | Role: " + role);
    }
}



