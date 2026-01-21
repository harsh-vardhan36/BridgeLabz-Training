package com.collections.setinterface.findsubset;

import java.util.Set;

public class SubsetUtil {

    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        return set2.containsAll(set1);
    }
}
