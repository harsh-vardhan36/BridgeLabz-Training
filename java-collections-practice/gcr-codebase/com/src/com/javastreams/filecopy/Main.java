package com.javastreams.filecopy;

public class Main {

    public static void main(String[] args) {

        String sourceFile = "largefile.txt"; // e.g. 100MB
        String normalCopy = "normal_copy.txt";
        String bufferedCopy = "buffered_copy.txt";

        long normalTime = FileCopyUtil.copyFile(sourceFile, normalCopy);
        long bufferedTime = BufferedFileCopyUtil.copyFile(sourceFile, bufferedCopy);

        System.out.println("Unbuffered Time (ns): " + normalTime);
        System.out.println("Buffered Time (ns):   " + bufferedTime);
    }
}
