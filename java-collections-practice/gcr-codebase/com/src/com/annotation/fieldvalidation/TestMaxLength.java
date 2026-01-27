package com.annotation.fieldvalidation;

public class TestMaxLength {
    public static void main(String[] args) {

        User user1 = new User("Harsh");        // ✅ OK
        System.out.println(user1.getUsername());

        User user2 = new User("VeryLongUsername"); // ❌ Exception
    }
}
