package com.runtimeanalysis;

import java.util.*;

public class DataStructureSearchComparison {

    public static void main(String[] args) {

        int n = 1_000_00; // try 1_000, 100_000, 1_000_000
        int target = n - 1;

        // Array
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        long start = System.nanoTime();
        for (int i : array) {
            if (i == target)
                break;
        }
        long end = System.nanoTime();
        System.out.println("Array Search Time: " + (end - start) / 1_000_000.0 + " ms");

        // HashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }

        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) / 1_000_000.0 + " ms");

        // TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }

        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
