package com.javastreams.imagetobytearray;

public class Main {

    public static void main(String[] args) {

        String originalImage = "original.jpg";
        String newImage = "copied.jpg";

        try {
            byte[] imageBytes =
                    ImageByteUtil.imageToByteArray(originalImage);

            ImageByteUtil.byteArrayToImage(imageBytes, newImage);

            boolean isSame =
                    ImageCompareUtil.compareImages(originalImage, newImage);

            System.out.println("Images are identical: " + isSame);

        } catch (Exception e) {
            System.out.println("Error while processing image");
        }
    }
}
