package com.collections.listInterface.remove;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> list =
                Arrays.asList(3, 1, 2, 2, 3, 4);

        List<Integer> result =
                RemoveDuplicateUtil.removeDuplicates(list);

        System.out.println(result);
    }
}
