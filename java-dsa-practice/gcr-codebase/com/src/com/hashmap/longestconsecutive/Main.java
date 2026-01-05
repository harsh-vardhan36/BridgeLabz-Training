package com.hashmap.longestconsecutive;
public class Main {

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        int result = LongestConsecutiveSequence.findLongest(arr);
        System.out.println(result);
    }
}
