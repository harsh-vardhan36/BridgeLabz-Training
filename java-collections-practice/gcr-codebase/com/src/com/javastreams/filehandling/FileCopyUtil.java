package com.javastreams.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyUtil {

    public static void copyFile(String sourceFile, String destinationFile) {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationFile);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Source file not found or error occurred!");

        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing files");
            }
        }
    }
}
