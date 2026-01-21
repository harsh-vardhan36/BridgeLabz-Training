package com.javastreams.uppercasetolowercase;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileCaseConverter {

    public static void convertUpperToLower(String sourceFile, String destFile) {

        try (
            // Handle character encoding properly
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(sourceFile),
                            StandardCharsets.UTF_8
                    )
            );

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(destFile),
                            StandardCharsets.UTF_8
                    )
            )
        ) {

            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase((char) ch));
            }

            System.out.println("File converted successfully!");

        } catch (IOException e) {
            System.out.println("Error while processing file");
        }
    }
}
