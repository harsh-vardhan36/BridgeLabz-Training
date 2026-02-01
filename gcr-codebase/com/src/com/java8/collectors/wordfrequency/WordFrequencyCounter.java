package com.java8.collectors.wordfrequency;

import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        String paragraph = "java streams make java powerful and streams make code clean";

        Map<String, Integer> wordCount =
                Arrays.stream(paragraph.split("\\s+"))
                      .collect(Collectors.toMap(
                          word -> word,          // key = word
                          word -> 1,             // initial count
                          Integer::sum            // merge if duplicate
                      ));

        wordCount.forEach((word, count) ->
            System.out.println(word + " → " + count)
        );
    }
}
