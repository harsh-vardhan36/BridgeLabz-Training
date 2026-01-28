package com.csv;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortCsvBySalaryApp {

    static class Employee {
        String id;
        String name;
        String department;
        int salary;

        Employee(String id, String name, String department, int salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        try {
            InputStream is = SortCsvBySalaryApp.class
                    .getClassLoader()
                    .getResourceAsStream("employees.csv");

            if (is == null) {
                System.out.println("employees.csv not found");
                return;
            }

            CSVReader reader = new CSVReader(new InputStreamReader(is));

            // Skip header
            reader.readNext();

            String[] row;

            while ((row = reader.readNext()) != null) {
                employees.add(
                        new Employee(
                                row[0],
                                row[1],
                                row[2],
                                Integer.parseInt(row[3])
                        )
                );
            }

            reader.close();

            // Sort by salary descending
            employees.sort(
                    Comparator.comparingInt((Employee e) -> e.salary).reversed()
            );

            System.out.println("Top 5 highest-paid employees");
            System.out.println("--------------------------------");

            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                Employee e = employees.get(i);
                System.out.println(
                        e.name + " | " +
                        e.department + " | Salary: " + e.salary
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
