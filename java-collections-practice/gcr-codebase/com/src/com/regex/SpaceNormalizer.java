package com.regex;

public class SpaceNormalizer {

    public static void main(String[] args) {

        String text = "This   is   an   example   with   multiple    spaces.";

        String result = text.replaceAll(" +", " ");

        System.out.println(result);
    }
}
