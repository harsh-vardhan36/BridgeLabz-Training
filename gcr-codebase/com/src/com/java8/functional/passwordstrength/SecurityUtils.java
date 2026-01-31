package com.java8.functional.passwordstrength;

public interface SecurityUtils {

    static boolean isStrongPassword(String password) {

        if (password == null) {
            return false;
        }

        //  Minimum length
        if (password.length() < 8) {
            return false;
        }
        
        boolean hasUppercase = password.chars()
                                       .anyMatch(Character::isUpperCase);

        // At least one digit
        boolean hasDigit = password.chars()
                                   .anyMatch(Character::isDigit);

        //  At least one special character
        boolean hasSpecialChar = password.matches(".*[@#$%!].*");

        return hasUppercase && hasDigit && hasSpecialChar;
    }
}
