package com.collections.setinterface.setEqual;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Integer> set1 =
                new HashSet<>(Arrays.asList(1, 2, 3));

        Set<Integer> set2 =
                new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> union =
                SetOperationUtil.findUnion(set1, set2);

        Set<Integer> intersection =
                SetOperationUtil.findIntersection(set1, set2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}
