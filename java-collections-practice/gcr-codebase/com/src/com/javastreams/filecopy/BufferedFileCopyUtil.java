package com.javastreams.filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedFileCopyUtil {

    public static long copyFile(String source, String dest) {

        long startTime = System.nanoTime();

        try (
            BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(dest))
        ) {

            byte[] buffer = new byte[4096]; // 4 KB
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in buffered copy");
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
