package com.csv;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;

public class SearchEmployeeCsvApp {

    public static void main(String[] args) {

        String searchName = "Harsh"; // searching

        boolean found = false;

        try {
            InputStream is = SearchEmployeeCsvApp.class
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

                String name = row[1];

                if (name.equalsIgnoreCase(searchName)) {

                    System.out.println("Employee Found");
                    System.out.println("Name       : " + row[1]);
                    System.out.println("Department : " + row[2]);
                    System.out.println("Salary     : " + row[3]);

                    found = true;
                    break;
                }
            }

            reader.close();

            if (!found) {
                System.out.println("Employee not found: " + searchName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
