package com.csv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCsvApp {

    public static void main(String[] args) {

        String filePath = "src/main/resources/employees.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

            // Header
            String[] header = {"ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            // Records
            writer.writeNext(new String[]{"1", "Harsh", "IT", "60000"});
            writer.writeNext(new String[]{"2", "Rahul", "HR", "45000"});
            writer.writeNext(new String[]{"3", "Aman", "Finance", "55000"});
            writer.writeNext(new String[]{"4", "Neha", "Marketing", "50000"});
            writer.writeNext(new String[]{"5", "Pooja", "Sales", "48000"});

            System.out.println("employees.csv file written successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
