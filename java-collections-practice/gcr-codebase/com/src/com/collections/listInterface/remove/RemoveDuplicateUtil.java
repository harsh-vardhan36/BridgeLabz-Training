package com.collections.listInterface.remove;

import java.util.*;

public class RemoveDuplicateUtil {

    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>();

        for (Integer val : list) {
            set.add(val); // duplicates automatically ignored
        }

        return new ArrayList<>(set);
    }
}
