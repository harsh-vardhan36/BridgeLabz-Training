package com.csv;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;

public class CsvApp {

    public static void main(String[] args) {

        try {
            InputStream is = CsvApp.class
                    .getClassLoader()
                    .getResourceAsStream("students.csv");

            if (is == null) {
                System.out.println("CSV file not found!");
                return;
            }

            CSVReader reader = new CSVReader(new InputStreamReader(is));
            String[] row;

            boolean isHeader = true;

            while ((row = reader.readNext()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                System.out.println("Student ID : " + row[0]);
                System.out.println("Name       : " + row[1]);
                System.out.println("Age        : " + row[2]);
                System.out.println("Marks      : " + row[3]);
                System.out.println("-----------------------");
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

