package com.dealtracker;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.*;

public class DealParser {

    private static final Pattern CODE =
            Pattern.compile("DealCode:\\s*(\\w+)");
    private static final Pattern DATE =
            Pattern.compile("ValidTill:\\s*(\\d{2}-\\d{2}-\\d{4})");
    private static final Pattern DISCOUNT =
            Pattern.compile("Discount:\\s*(\\d+)%");
    private static final Pattern MIN =
            Pattern.compile("MinimumPurchase:\\s*(\\d+)");

    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static Deal parse(File file) throws IOException {

        String content = readFile(file);

        Matcher m1 = CODE.matcher(content);
        Matcher m2 = DATE.matcher(content);
        Matcher m3 = DISCOUNT.matcher(content);
        Matcher m4 = MIN.matcher(content);

        if (!(m1.find() && m2.find() && m3.find() && m4.find()))
            throw new IllegalArgumentException("Invalid deal format");

        return new Deal(
                m1.group(1),
                LocalDate.parse(m2.group(1), FORMAT),
                Integer.parseInt(m3.group(1)),
                Integer.parseInt(m4.group(1))
        );
    }

    private static String readFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = fis.read()) != -1) {
            sb.append((char) ch);
        }
        fis.close();
        return sb.toString();
    }
}
