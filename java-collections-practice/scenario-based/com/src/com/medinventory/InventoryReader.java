package com.medinventory;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.*;

public class InventoryReader {

    private static final Pattern DATE_PATTERN =
            Pattern.compile("\\d{2}-\\d{2}-\\d{4}");

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static <T> Set<InventoryItem<T>> readInventory(
            String filePath, T type) {

        Set<InventoryItem<T>> items = new HashSet<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(",");

                    if (parts.length != 4)
                        throw new IllegalArgumentException("Invalid CSV");

                    Matcher m = DATE_PATTERN.matcher(parts[3]);
                    if (!m.matches())
                        throw new IllegalArgumentException("Invalid date");

                    InventoryItem<T> item =
                            new InventoryItem<>(
                                    parts[0],
                                    parts[1],
                                    Integer.parseInt(parts[2]),
                                    LocalDate.parse(parts[3], FORMATTER),
                                    type
                            );
                    items.add(item);

                } catch (Exception e) {
                    // skip invalid line safely
                }
            }
        } catch (IOException e) {
            System.out.println("File read error");
        }
        return items;
    }
}
