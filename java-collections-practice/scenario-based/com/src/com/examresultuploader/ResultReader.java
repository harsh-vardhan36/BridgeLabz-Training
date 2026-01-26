package com.examresultuploader;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ResultReader {

    // RollNo,Name,Subject,Marks
    private static final Pattern VALID_LINE =
            Pattern.compile("\\d+,[A-Za-z ]+,[A-Za-z]+,\\d{1,3}");

    public static <T> List<ExamRecord<T>> readResults(
            String filePath, T examType)
            throws InvalidResultException {

        List<ExamRecord<T>> records = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                if (!VALID_LINE.matcher(line).matches())
                    throw new InvalidResultException(
                            "Invalid format: " + line);

                String[] parts = line.split(",");

                int marks = Integer.parseInt(parts[3]);
                if (marks < 0 || marks > 100)
                    throw new InvalidResultException(
                            "Invalid marks: " + marks);

                records.add(new ExamRecord<>(
                        parts[0],
                        parts[1],
                        parts[2],
                        marks,
                        examType
                ));
            }

        } catch (IOException e) {
            throw new InvalidResultException("File read error");
        }

        return records;
    }
}
