package com.annotation.supresswarnings;

import java.util.ArrayList;

class WarningDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList(); //  unchecked warning
        list.add("Java");
        list.add(100);   // mixed types allowed

        System.out.println(list);
    }
}
