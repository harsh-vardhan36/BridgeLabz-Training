package com.hashmap.pairsum;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        boolean result = PairWithSum.hasPair(arr, target);
        System.out.println(result);
    }
}
