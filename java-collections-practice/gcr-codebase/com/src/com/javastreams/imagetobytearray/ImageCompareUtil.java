package com.javastreams.imagetobytearray;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ImageCompareUtil {

    public static boolean compareImages(String img1, String img2) throws IOException {

        byte[] image1Bytes;
        byte[] image2Bytes;

        try (
            FileInputStream fis1 = new FileInputStream(img1);
            FileInputStream fis2 = new FileInputStream(img2)
        ) {
            image1Bytes = fis1.readAllBytes();
            image2Bytes = fis2.readAllBytes();
        }

        return Arrays.equals(image1Bytes, image2Bytes);
    }
}
