package com.javastreams.countwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCountUtil {

    public static void countTopWords(String filePath) {

        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                // Normalize text
                line = line.toLowerCase().replaceAll("[^a-z ]", "");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(
                                word,
                                wordCountMap.getOrDefault(word, 0) + 1
                        );
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error while reading file");
            return;
        }

        // Sort by frequency (descending)
        List<Map.Entry<String, Integer>> sortedList =
                new ArrayList<>(wordCountMap.entrySet());

        sortedList.sort((a, b) -> b.getValue() - a.getValue());

        // Display top 5
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            System.out.println(
                    sortedList.get(i).getKey() + " : " +
                    sortedList.get(i).getValue()
            );
        }
    }
}
