package com.collections.setinterface.findsubset;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Integer> set1 =
                new HashSet<>(Arrays.asList(2, 3));

        Set<Integer> set2 =
                new HashSet<>(Arrays.asList(1, 2, 3, 4));

        boolean result =
                SubsetUtil.isSubset(set1, set2);

        System.out.println(result);
    }
}
