package com.examscanner;

import java.util.*;

public class ResultProcessor {

    public static <T> Map<String, Integer> evaluate(
            List<AnswerSheet<T>> sheets,
            List<T> answerKey) {

        Map<String, Integer> scores = new HashMap<>();

        for (AnswerSheet<T> sheet : sheets) {
            int score = 0;
            List<T> answers = sheet.getAnswers();

            for (int i = 0; i < Math.min(answers.size(), answerKey.size()); i++) {
                if (answers.get(i).equals(answerKey.get(i))) {
                    score++;
                }
            }
            scores.put(sheet.getStudentName(), score);
        }
        return scores;
    }

    public static PriorityQueue<Map.Entry<String, Integer>> rank(
            Map<String, Integer> scores) {

        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>(
                        (a, b) -> b.getValue() - a.getValue());

        pq.addAll(scores.entrySet());
        return pq;
    }
}
