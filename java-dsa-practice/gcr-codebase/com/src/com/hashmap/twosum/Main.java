package com.hashmap.twosum;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = TwoSum.findTwoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
