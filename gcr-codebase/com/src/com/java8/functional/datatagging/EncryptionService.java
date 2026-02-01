package com.java8.functional.datatagging;

public class EncryptionService {

    public static void process(Object obj) {

        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data: " +
                    obj.getClass().getSimpleName());
            // encryption logic here
        } else {
            System.out.println("No encryption needed");
        }
    }
}
