package com.collections.listInterface.frequency;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = Arrays.asList(
                "apple", "banana", "apple", "orange"
        );

        Map<String, Integer> result =
                FrequencyUtil.countFrequency(list);

        System.out.println(result);
    }
}
