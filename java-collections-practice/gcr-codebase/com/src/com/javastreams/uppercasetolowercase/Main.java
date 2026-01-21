package com.javastreams.uppercasetolowercase;
public class Main {

    public static void main(String[] args) {

        String sourceFile = "input.txt";
        String destFile = "output.txt";

        FileCaseConverter.convertUpperToLower(sourceFile, destFile);
    }
}
