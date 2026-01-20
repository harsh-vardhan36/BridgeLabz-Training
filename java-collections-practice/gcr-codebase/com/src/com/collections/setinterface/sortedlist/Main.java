package com.collections.setinterface.sortedlist;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Integer> set =
                new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList =
                SetToSortedListUtil.convertToSortedList(set);

        System.out.println(sortedList);
    }
}
