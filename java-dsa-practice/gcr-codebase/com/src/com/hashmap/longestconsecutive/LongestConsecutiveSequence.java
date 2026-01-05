package com.hashmap.longestconsecutive;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int findLongest(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
