package com.csv;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class DetectDuplicateCsvApp {

    public static void main(String[] args) {

        Set<String> seenIds = new HashSet<>();
        Set<String> duplicateIds = new HashSet<>();
        List<String[]> allRows = new ArrayList<>();

        try {
            InputStream is = DetectDuplicateCsvApp.class
                    .getClassLoader()
                    .getResourceAsStream("students.csv");

            if (is == null) {
                System.out.println("students.csv not found");
                return;
            }

            CSVReader reader = new CSVReader(new InputStreamReader(is));

            // Read header
            String[] header = reader.readNext();

            String[] row;
            while ((row = reader.readNext()) != null) {

                String id = row[0];

                if (!seenIds.add(id)) {
                    duplicateIds.add(id);
                }

                allRows.add(row);
            }

            reader.close();

            // Print duplicate records
            System.out.println("Duplicate Records:");
            System.out.println(String.join(", ", header));

            for (String[] r : allRows) {
                if (duplicateIds.contains(r[0])) {
                    System.out.println(String.join(", ", r));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
