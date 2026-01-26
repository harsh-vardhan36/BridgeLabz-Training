package com.chatlogparser;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        MessageFilter<String> filter =
                new IdleChatFilter();

        Map<String, List<String>> chats =
                ChatLogParser.parse(
                        "chatlogs.txt", filter);

        chats.forEach((user, messages) -> {
            System.out.println("\nUser: " + user);
            messages.forEach(m ->
                    System.out.println("  - " + m));
        });
    }
}
