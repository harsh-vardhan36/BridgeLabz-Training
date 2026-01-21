package com.mapinterface.wordfrequencycounter;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWords(String filePath) throws IOException {

        Map<String, Integer> wordCount = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {


            line = line.toLowerCase().replaceAll("[^a-z ]", "");

            String[] words = line.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        br.close();
        return wordCount;
    }
}
