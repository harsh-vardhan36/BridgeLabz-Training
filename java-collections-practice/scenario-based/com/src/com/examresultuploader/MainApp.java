package com.examresultuploader;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        try {
            List<ExamRecord<String>> records =
                    ResultReader.readResults(
                            "marks.csv", "FinalExam");

            Map<String, List<Integer>> subjectMarks =
                    ResultAnalyzer.subjectWiseMarks(records);

            Map<String, Integer> toppers =
                    ResultAnalyzer.topScorers(subjectMarks);

            System.out.println("Top Scorers:");
            toppers.forEach((sub, score) ->
                    System.out.println(sub + " → " + score));

        } catch (InvalidResultException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
