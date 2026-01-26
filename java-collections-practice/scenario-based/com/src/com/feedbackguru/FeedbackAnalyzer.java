package com.feedbackguru;

import java.util.*;

public class FeedbackAnalyzer {

    public static <T> Map<String, List<Feedback<T>>> categorize(
            List<Feedback<T>> feedbacks) {

        Map<String, List<Feedback<T>>> result = new HashMap<>();
        result.put("Positive", new ArrayList<>());
        result.put("Neutral", new ArrayList<>());
        result.put("Negative", new ArrayList<>());

        for (Feedback<T> f : feedbacks) {
            int r = f.getRating();

            if (r >= 8)
                result.get("Positive").add(f);
            else if (r >= 5)
                result.get("Neutral").add(f);
            else
                result.get("Negative").add(f);
        }
        return result;
    }
}
