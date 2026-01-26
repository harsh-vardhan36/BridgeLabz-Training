package com.chatlogparser;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ChatLogParser {

    // [12:02 PM] John: Message
    private static final Pattern LOG_PATTERN =
            Pattern.compile("\\[(.*?)\\]\\s(.*?):\\s(.*)");

    public static Map<String, List<String>> parse(
            String filePath,
            MessageFilter<String> filter) {

        Map<String, List<String>> userMessages =
                new TreeMap<>(); // auto-sorted

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Matcher m = LOG_PATTERN.matcher(line);
                    if (!m.matches())
                        throw new IllegalArgumentException("Bad format");

                    String user = m.group(2);
                    String message = m.group(3);

                    if (!filter.allow(message)) continue;

                    userMessages
                            .computeIfAbsent(user,
                                    k -> new ArrayList<>())
                            .add(message);

                } catch (Exception e) {
                    // Skip invalid log line safely
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading chat logs");
        }

        return userMessages;
    }
}
