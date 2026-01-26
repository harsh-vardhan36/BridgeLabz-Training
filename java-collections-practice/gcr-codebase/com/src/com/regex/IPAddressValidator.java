package com.regex;
import java.util.*;

public class IPAddressValidator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean isTrue = true;

        String regex =
            "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" +
            "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

        while (isTrue) {

            System.out.println("Enter IPv4 Address:");
            String ip = in.nextLine();

            if (ip.matches(regex)) {
                System.out.println("Valid IP Address");
            } else {
                System.out.println("Invalid IP Address");
            }

            System.out.println("Check again? (y/n)");
            char ch = in.next().charAt(0);
            in.nextLine(); // consume newline

            if (ch != 'y') {
                isTrue = false;
            }
        }
        in.close();
    }
}
