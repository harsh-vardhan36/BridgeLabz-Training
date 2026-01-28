package com.csv;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;

public class FilterCsvApp {

    public static void main(String[] args) {

        try {
            InputStream is = FilterCsvApp.class
                    .getClassLoader()
                    .getResourceAsStream("students.csv");

            if (is == null) {
                System.out.println("CSV file not found");
                return;
            }

            CSVReader reader = new CSVReader(new InputStreamReader(is));

            // Skip header
            reader.readNext();

            String[] row;

            System.out.println("Students with marks > 80");
            System.out.println("-------------------------");

            while ((row = reader.readNext()) != null) {

                int marks = Integer.parseInt(row[3]);

                if (marks > 80) {
                    System.out.println(
                            "ID: " + row[0] +
                            ", Name: " + row[1] +
                            ", Age: " + row[2] +
                            ", Marks: " + row[3]
                    );
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
