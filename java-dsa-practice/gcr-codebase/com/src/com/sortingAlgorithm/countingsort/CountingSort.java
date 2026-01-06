package com.sortingAlgorithm.countingsort;

class CountingSort {

    public static void sort(int[] ages) {

        int minAge = 10;
        int maxAge = 18;

        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Step 1: Count frequency
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build output array (stable sort)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            int index = count[age - minAge] - 1;
            output[index] = age;
            count[age - minAge]--;
        }

        // Copy back to original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }
}
