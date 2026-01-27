package com.annotation.fieldvalidation;

import java.lang.reflect.Field;

class User {

    @MaxLength(10)
    private String username;

    public User(String username) {

        try {
            Field field = this.getClass().getDeclaredField("username");

            if (field.isAnnotationPresent(MaxLength.class)) {

                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        "Username exceeds max length of " + maxLength.value()
                    );
                }
            }

            this.username = username;

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}
