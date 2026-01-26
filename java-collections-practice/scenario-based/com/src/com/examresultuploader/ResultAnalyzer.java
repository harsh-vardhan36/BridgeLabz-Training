package com.examresultuploader;

import java.util.*;

public class ResultAnalyzer {

    public static Map<String, List<Integer>> subjectWiseMarks(
            List<ExamRecord<?>> records) {

        Map<String, List<Integer>> map = new HashMap<>();

        for (ExamRecord<?> r : records) {
            map.computeIfAbsent(
                    r.getSubject(),
                    k -> new ArrayList<>())
               .add(r.getMarks());
        }
        return map;
    }

    public static Map<String, Integer> topScorers(
            Map<String, List<Integer>> subjectMarks) {

        Map<String, Integer> toppers = new HashMap<>();

        for (var entry : subjectMarks.entrySet()) {

            PriorityQueue<Integer> pq =
                    new PriorityQueue<>(Collections.reverseOrder());

            pq.addAll(entry.getValue());
            toppers.put(entry.getKey(), pq.peek());
        }
        return toppers;
    }
}
