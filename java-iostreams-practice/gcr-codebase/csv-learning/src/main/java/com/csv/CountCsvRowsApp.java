package com.csv;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;

public class CountCsvRowsApp {

    public static void main(String[] args) {

        int count = 0;

        try {
            InputStream is = CountCsvRowsApp.class
                    .getClassLoader()
                    .getResourceAsStream("students.csv");

            if (is == null) {
                System.out.println("CSV file not found");
                return;
            }

            CSVReader reader = new CSVReader(new InputStreamReader(is));
            String[] row;

            boolean isHeader = true;

            while ((row = reader.readNext()) != null) {

                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                count++;
            }

            reader.close();

            System.out.println("Number of records (excluding header): " + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
