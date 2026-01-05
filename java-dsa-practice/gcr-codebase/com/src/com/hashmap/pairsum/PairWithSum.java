package com.hashmap.pairsum;

import java.util.HashSet;

public class PairWithSum {

    public static boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int required = target - num;

            if (set.contains(required)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
