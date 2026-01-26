package com.feedbackguru;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FeedbackReader {

    private static final Pattern RATING_PATTERN =
            Pattern.compile("(\\d{1,2})/10");

    public static <T> List<Feedback<T>> readFeedback(
            String folderPath, T type) {

        List<Feedback<T>> feedbackList = new ArrayList<>();
        File folder = new File(folderPath);

        for (File file : folder.listFiles()) {
            if (!file.getName().endsWith(".txt")) continue;

            try (BufferedReader br =
                         new BufferedReader(new FileReader(file))) {

                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        Matcher m = RATING_PATTERN.matcher(line);

                        if (!m.find())
                            throw new IllegalArgumentException("No rating");

                        int rating = Integer.parseInt(m.group(1));
                        feedbackList.add(
                                new Feedback<>(type, line, rating));

                    } catch (Exception e) {
                        // skip invalid line
                    }
                }

            } catch (IOException e) {
                System.out.println("Skipping file: " + file.getName());
            }
        }
        return feedbackList;
    }
}
