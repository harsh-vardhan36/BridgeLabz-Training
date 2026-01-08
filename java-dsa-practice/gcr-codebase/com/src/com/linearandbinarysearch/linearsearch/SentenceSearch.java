package com.linearandbinarysearch.linearsearch;

public class SentenceSearch {

    public static String findSentence(String[] sentences, String word) {

        
        for (String sentence : sentences) {

            // Check if sentence contains the word
            if (sentence.contains(word)) {
                return sentence;
            }
        }

        
        return "Not Found";
    }

    public static void main(String[] args) {

        String[] sentences = {
            "Java is fun",
            "I love coding",
            "Linear search is simple",
            "Data structures are important"
        };

        String word = "search";

        String result = findSentence(sentences, word);
        System.out.println(result);
    }
}
