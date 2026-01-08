package com.linearandbinarysearch.filereader;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) {

        String targetWord = "java";   
        int count = 0;

        try {
            FileReader fr = new FileReader("sample.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {

                // Split line into words
                String[] words = line.split("\\s+");

                // Check each word
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();
            fr.close();

            System.out.println("Word '" + targetWord + "' appears " + count + " times.");

        } catch (IOException e) {
            System.out.println("Error reading the file");
        }
    }
}
