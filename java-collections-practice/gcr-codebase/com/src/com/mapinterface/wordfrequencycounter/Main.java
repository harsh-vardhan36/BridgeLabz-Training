package com.mapinterface.wordfrequencycounter;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            Map<String, Integer> result =
                    WordFrequencyCounter.countWords("input.txt");

            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
