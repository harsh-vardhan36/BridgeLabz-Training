package com.javastreams.readalargefile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ErrorLogReader {

    public static void readErrorLines(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                // Case-insensitive check
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error while reading the file");
        }
    }
}
