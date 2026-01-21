package com.javastreams.readalargefile;

public class Main {

    public static void main(String[] args) {

        String largeFilePath = "large_log_file.txt"; // 500MB+

        ErrorLogReader.readErrorLines(largeFilePath);
    }
}
