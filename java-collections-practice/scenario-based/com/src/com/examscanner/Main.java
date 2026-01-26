package com.examscanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> answerKey =
                Arrays.asList("A", "B", "C", "D", "A", "B", "C");

        List<AnswerSheet<String>> sheets =
                ExamScanner.readSheets(
                        "answers.csv", String.class);

        Map<String, Integer> scores =
                ResultProcessor.evaluate(sheets, answerKey);

        PriorityQueue<Map.Entry<String, Integer>> ranked =
                ResultProcessor.rank(scores);

        System.out.println("Results:");
        while (!ranked.isEmpty()) {
            var e = ranked.poll();
            System.out.println(e.getKey() + " → " + e.getValue());
        }
    }
}
