package com.junit.usertest;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {

        if (username == null || username.length() < 3) {
            throw new IllegalArgumentException("Invalid username");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid password");
        }

        // no return needed for this problem
    }
}
