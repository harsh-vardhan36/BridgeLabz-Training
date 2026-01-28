package com.csv;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MergeCsvApp {

    public static void main(String[] args) {

        Map<Integer, Students> studentMap = new HashMap<>();

        try {
            // ---- Read students1.csv ----
            InputStream is1 = MergeCsvApp.class
                    .getClassLoader()
                    .getResourceAsStream("students1.csv");

            CSVReader reader1 = new CSVReader(new InputStreamReader(is1));
            reader1.readNext(); // skip header

            String[] row;
            while ((row = reader1.readNext()) != null) {
                int id = Integer.parseInt(row[0]);
                studentMap.put(id,
                        new Students(id, row[1], Integer.parseInt(row[2])));
            }
            reader1.close();

            // ---- Read students2.csv ----
            InputStream is2 = MergeCsvApp.class
                    .getClassLoader()
                    .getResourceAsStream("students2.csv");

            CSVReader reader2 = new CSVReader(new InputStreamReader(is2));
            reader2.readNext(); // skip header

            while ((row = reader2.readNext()) != null) {
                int id = Integer.parseInt(row[0]);
                if (studentMap.containsKey(id)) {
                    studentMap.get(id)
                            .setMarksAndGrade(
                                    Integer.parseInt(row[1]),
                                    row[2]
                            );
                }
            }
            reader2.close();

            // ---- Print merged data ----
            System.out.println("ID, Name, Age, Marks, Grade");
            studentMap.values().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
