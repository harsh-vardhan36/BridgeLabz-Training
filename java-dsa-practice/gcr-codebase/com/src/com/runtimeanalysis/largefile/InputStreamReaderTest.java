package com.runtimeanalysis.largefile;

import java.io.*;

public class InputStreamReaderTest {

    public static void main(String[] args) throws Exception {

        InputStreamReader isr =
                new InputStreamReader(new FileInputStream("largefile.txt"));
        BufferedReader br = new BufferedReader(isr);

        long start = System.nanoTime();

        while (br.readLine() != null) {
            // reading file
        }

        long end = System.nanoTime();

        br.close();
        System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
