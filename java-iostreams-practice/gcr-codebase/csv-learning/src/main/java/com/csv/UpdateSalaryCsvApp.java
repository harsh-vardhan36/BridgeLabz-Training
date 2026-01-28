package com.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UpdateSalaryCsvApp {

    public static void main(String[] args) {

        String outputFile = "src/main/resources/employees_updated.csv";

        try {
            InputStream is = UpdateSalaryCsvApp.class
                    .getClassLoader()
                    .getResourceAsStream("employees.csv");

            if (is == null) {
                System.out.println("employees.csv not found");
                return;
            }

            CSVReader reader = new CSVReader(new InputStreamReader(is));
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile));

            String[] row;

            // Write header as-is
            writer.writeNext(reader.readNext());

            while ((row = reader.readNext()) != null) {

                String department = row[2];
                double salary = Double.parseDouble(row[3]);

                // Increase salary by 10% for IT department
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10;
                }

                row[3] = String.valueOf((int) salary);
                writer.writeNext(row);
            }

            reader.close();
            writer.close();

            System.out.println("Updated CSV file created: employees_updated.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
