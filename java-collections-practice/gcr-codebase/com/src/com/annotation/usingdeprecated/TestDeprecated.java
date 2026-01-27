package com.annotation.usingdeprecated;

public class TestDeprecated {
    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        api.oldFeature();   // Warning in IDE
        api.newFeature();   //  No warning
    }
}
