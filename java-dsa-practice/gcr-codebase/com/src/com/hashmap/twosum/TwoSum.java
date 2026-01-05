package com.hashmap.twosum;

import java.util.HashMap;

public class TwoSum {

    public static int[] findTwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int required = target - arr[i];

            if (map.containsKey(required)) {
                return new int[]{ map.get(required), i };
            }

            map.put(arr[i], i);
        }
        return new int[]{ -1, -1 };
    }
}
