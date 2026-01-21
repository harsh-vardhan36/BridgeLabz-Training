package com.javastreams.imagetobytearray;

import java.io.*;

public class ImageByteUtil {

    // Convert image to byte array
    public static byte[] imageToByteArray(String imagePath) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (FileInputStream fis = new FileInputStream(imagePath)) {

            byte[] buffer = new byte[4096]; // 4 KB
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
        }

        return baos.toByteArray();
    }

    // Convert byte array back to image
    public static void byteArrayToImage(byte[] imageBytes, String outputPath)
            throws IOException {

        try (
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputPath)
        ) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
