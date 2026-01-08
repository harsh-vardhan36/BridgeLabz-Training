package com.linearandbinarysearch.filereader;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class ReadFile {
    public static void main(String[] args) {

        try {
            // 1. Create FileReader
            FileReader fr = new FileReader("sample.txt");

            // 2. Wrap it with BufferedReader
            BufferedReader br = new BufferedReader(fr);

            String line;

            // 3. Read file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // 4. Close the file
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading the file");
        }
    }

}
