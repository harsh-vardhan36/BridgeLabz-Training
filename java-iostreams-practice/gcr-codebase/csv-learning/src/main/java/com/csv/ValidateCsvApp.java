package com.csv;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ValidateCsvApp {

    // Regex patterns
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\d{10}$");

    public static void main(String[] args) {

        try {
            InputStream is = ValidateCsvApp.class
                    .getClassLoader()
                    .getResourceAsStream("users.csv");

            if (is == null) {
                System.out.println("users.csv not found");
                return;
            }

            CSVReader reader = new CSVReader(new InputStreamReader(is));

            // Skip header
            reader.readNext();

            String[] row;
            int rowNumber = 2; // data starts after header

            while ((row = reader.readNext()) != null) {

                String email = row[2];
                String phone = row[3];

                boolean valid = true;

                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.println("Row " + rowNumber +
                            "  Invalid Email: " + email);
                    valid = false;
                }

                if (!PHONE_PATTERN.matcher(phone).matches()) {
                    System.out.println("Row " + rowNumber +
                            "  Invalid Phone: " + phone);
                    valid = false;
                }

                if (!valid) {
                    System.out.println("   ➜ Full Row: " + String.join(", ", row));
                }

                rowNumber++;
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
