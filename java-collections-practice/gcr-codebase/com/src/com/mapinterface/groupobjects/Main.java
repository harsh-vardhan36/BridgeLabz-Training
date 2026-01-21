package com.mapinterface.groupobjects;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map<String, List<Employee>> result =
                EmployeeGrouper.groupByDepartment(employees);

        System.out.println(result);
    }
}
