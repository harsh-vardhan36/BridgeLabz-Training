package com.collections.listInterface.nthfromend;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> list =
                new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));

        int n = 2;

        String result =
                NthFromEndUtil.findNthFromEnd(list, n);

        System.out.println(result);
    }
}
