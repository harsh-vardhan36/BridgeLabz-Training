package com.regex;
import java.util.*;

public class CreditCardValidator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean isTrue = true;

        String regex = "^(4|5)\\d{15}$";

        while (isTrue) {

            System.out.println("Enter Credit Card Number:");
            String card = in.nextLine();

            if (card.matches(regex)) {
                System.out.println("Valid Credit Card Number");
            } else {
                System.out.println("Invalid Credit Card Number");
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
