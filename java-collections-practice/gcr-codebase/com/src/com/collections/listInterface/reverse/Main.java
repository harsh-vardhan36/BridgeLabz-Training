package com.collections.listInterface.reverse;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> arrayList =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> linkedList =
                new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        ReverseUtil.reverseList(arrayList);
        ReverseUtil.reverseList(linkedList);

        System.out.println("ArrayList reversed: " + arrayList);
        System.out.println("LinkedList reversed: " + linkedList);
    }
}
