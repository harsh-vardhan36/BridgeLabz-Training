package com.regex;
import java.util.*;

public class EmailValidator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean isTrue = true;

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        while (isTrue) {

            System.out.println("Enter the username: ");
            String username = in.nextLine();

            if (username.matches(regex)) {
                System.out.println("Verified!");
            } else {
                System.out.println("Not Verified!");
            }

            System.out.println("Do you want to check the Username again? (y/n)");
            char val = in.next().charAt(0);
            in.nextLine(); // consume newline

            if (val == 'y') {
                isTrue = true;
            } else {
                isTrue = false;
            }
        }
        in.close();
    }
}
