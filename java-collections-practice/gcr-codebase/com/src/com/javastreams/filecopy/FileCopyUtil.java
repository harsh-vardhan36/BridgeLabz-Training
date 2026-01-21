package com.javastreams.filecopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyUtil {

    public static long copyFile(String source, String dest) {

        long startTime = System.nanoTime();

        try (
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(dest)
        ) {

            byte[] buffer = new byte[4096]; // 4 KB
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in unbuffered copy");
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
