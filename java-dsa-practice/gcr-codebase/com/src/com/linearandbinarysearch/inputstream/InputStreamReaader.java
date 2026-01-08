package com.linearandbinarysearch.inputstream;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InputStreamReaader {
    public static void main(String[] args) {

        try {
            // 1. Byte stream
            FileInputStream fis = new FileInputStream("sample.txt");

            // 2. Convert byte stream to character stream (UTF-8)
            InputStreamReader isr =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);

            // 3. BufferedReader for efficient reading
            BufferedReader br = new BufferedReader(isr);

            String line;

            // 4. Read and print line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // 5. Close resources
            br.close();
            isr.close();
            fis.close();

        } catch (IOException e) {
            System.out.println("Error reading the file");
        }
    }
}
