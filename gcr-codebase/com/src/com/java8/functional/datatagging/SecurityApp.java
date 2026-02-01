package com.java8.functional.datatagging;

public class SecurityApp {

    public static void main(String[] args) {

        UserCredentials creds = new UserCredentials();
        PublicProductInfo product = new PublicProductInfo();

        EncryptionService.process(creds);
        EncryptionService.process(product);
    }
}
