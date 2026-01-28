package com.csv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class JsonToCsvApp {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // Read JSON into Student objects
        List<Student> students = mapper.readValue(
                new File("src/main/resources/students.json"),
                mapper.getTypeFactory()
                        .constructCollectionType(List.class, Student.class)
        );

        // Write CSV
        try (CSVWriter writer = new CSVWriter(
                new FileWriter("src/main/resources/students_from_json.csv"))) {

            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks"});

            for (Student s : students) {
                writer.writeNext(new String[]{
                        String.valueOf(s.getId()),
                        s.getName(),
                        String.valueOf(s.getAge()),
                        String.valueOf(s.getMarks())
                });
            }
        }

        System.out.println("JSON → CSV conversion done");
    }
}
