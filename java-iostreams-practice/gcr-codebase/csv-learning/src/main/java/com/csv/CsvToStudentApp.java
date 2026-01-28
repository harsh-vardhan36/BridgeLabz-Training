package com.csv;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvToStudentApp {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        try {
            InputStream is = CsvToStudentApp.class
                    .getClassLoader()
                    .getResourceAsStream("students.csv");

            if (is == null) {
                System.out.println("students.csv not found");
                return;
            }

            CSVReader reader = new CSVReader(new InputStreamReader(is));

            // Skip header
            reader.readNext();

            String[] row;

            while ((row = reader.readNext()) != null) {

                Student student = new Student(
                        Integer.parseInt(row[0]),
                        row[1],
                        Integer.parseInt(row[2]),
                        Integer.parseInt(row[3])
                );

                students.add(student);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print students
        students.forEach(System.out::println);
    }
}
