package com.examscanner;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ExamScanner {

    // Name + comma + answers like A,B,C,D
    private static final Pattern VALID_LINE =
            Pattern.compile("^[A-Za-z ]+(,[A-D])+$");

    public static <T> List<AnswerSheet<T>> readSheets(
            String filePath, Class<T> type) {

        List<AnswerSheet<T>> sheets = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                try {
                    if (!VALID_LINE.matcher(line).matches())
                        throw new IllegalArgumentException("Invalid format");

                    String[] parts = line.split(",");
                    String name = parts[0];

                    List<T> answers = new ArrayList<>();
                    for (int i = 1; i < parts.length; i++) {
                        answers.add(type.cast(parts[i]));
                    }

                    sheets.add(new AnswerSheet<>(name, answers));

                } catch (Exception e) {
                    // Skip bad lines safely
                }
            }

        } catch (IOException e) {
            System.out.println("File read error");
        }
        return sheets;
    }
}
