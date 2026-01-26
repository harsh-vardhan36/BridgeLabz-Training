package com.regex;

package com.regex;
import java.util.*;

public class LicensePlateValidator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean isTrue = true;

        String regex = "^[A-Z]{2}\\d{4}$";

        while (isTrue) {

            System.out.println("Enter License Plate Number: ");
            String plate = in.nextLine();

            if (plate.matches(regex)) {
                System.out.println("Valid License Plate!");
            } else {
                System.out.println("Invalid License Plate!");
            }

            System.out.println("Do you want to check again? (y/n)");
            char val = in.next().charAt(0);
            in.nextLine(); 

            if (val == 'y') {
                isTrue = true;
            } else {
                isTrue = false;
            }
        }
        in.close();
    }
}
