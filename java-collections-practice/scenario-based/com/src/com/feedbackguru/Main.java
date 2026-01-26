package com.feedbackguru;

import java.util.*;

public class Main{
    public static void main(String[] args) {

        List<Feedback<String>> feedbacks =
                FeedbackReader.readFeedback(
                        "feedbacks", "Service");

        Map<String, List<Feedback<String>>> grouped =
                FeedbackAnalyzer.categorize(feedbacks);

        grouped.forEach((k, v) -> {
            System.out.println("\n" + k + " Feedback:");
            v.forEach(System.out::println);
        });
    }
}
