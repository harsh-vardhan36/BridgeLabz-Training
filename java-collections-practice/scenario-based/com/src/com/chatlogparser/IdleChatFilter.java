package com.chatlogparser;

import java.util.List;

public class IdleChatFilter implements MessageFilter<String> {

    private final List<String> blockedKeywords =
            List.of("lol", "brb", "haha", "ttyl");

    @Override
    public boolean allow(String message) {
        String msg = message.toLowerCase();
        return blockedKeywords.stream()
                .noneMatch(msg::contains);
    }
}
