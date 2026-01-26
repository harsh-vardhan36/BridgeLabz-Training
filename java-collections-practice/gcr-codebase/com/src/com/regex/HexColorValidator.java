package com.regex;

import java.util.*;

public class HexColorValidator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean isTrue = true;

        String regex = "^#[0-9A-Fa-f]{6}$";

        while (isTrue) {

            System.out.println("Enter Hex Color Code: ");
            String color = in.nextLine();

            if (color.matches(regex)) {
                System.out.println("Valid Hex Color!");
            } else {
                System.out.println("Invalid Hex Color!");
            }

            System.out.println("Do you want to check again? (y/n)");
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
