package com.runtimeanalysis.largefile;

import java.io.*;

public class FileReaderTest {

    public static void main(String[] args) throws Exception {

        FileReader reader = new FileReader("largefile.txt");
        BufferedReader br = new BufferedReader(reader);

        long start = System.nanoTime();

        while (br.readLine() != null) {
            // reading file
        }

        long end = System.nanoTime();

        br.close();
        System.out.println("FileReader Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}

