package com.mapinterface.highestvalue;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String result = MaxValueFinder.findKeyWithMaxValue(map);

        System.out.println(result);
    }
}
