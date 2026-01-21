package com.mapinterface.mergemap;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> mergedMap =
                MapMerger.mergeMaps(map1, map2);

        System.out.println(mergedMap);
    }
}
