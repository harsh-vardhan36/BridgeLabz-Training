package com.scenariobased.markmate;

import java.util.*;

public class MarkProcessor {

    public static StudentMarksheet process(String[] header, String[] row) {

        try {
            int rollNo = Integer.parseInt(row[0]);
            String name = row[1];

            Map<String, Integer> subjectMarks = new LinkedHashMap<>();
            int total = 0;

            for (int i = 2; i < row.length; i++) {
                int mark = Integer.parseInt(row[i]);
                subjectMarks.put(header[i], mark);
                total += mark;
            }

            double average = total / (double) subjectMarks.size();
            String grade = calculateGrade(average);

            return new StudentMarksheet(rollNo, name, subjectMarks, total, average, grade);

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid marks for student: " + row[1]);
            return null;
        }
    }

    private static String calculateGrade(double avg) {
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 60) return "C";
        return "D";
    }
}
