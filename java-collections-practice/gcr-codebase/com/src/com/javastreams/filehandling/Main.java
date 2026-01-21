package com.javastreams.filehandling;

public class Main {

    public static void main(String[] args) {

        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        FileCopyUtil.copyFile(sourceFile, destinationFile);
    }
}
