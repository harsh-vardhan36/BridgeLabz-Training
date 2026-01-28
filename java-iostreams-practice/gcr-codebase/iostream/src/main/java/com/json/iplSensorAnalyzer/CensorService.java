package com.json.iplSensorAnalyzer;

import java.util.List;

public class CensorService {
    public static void applyCensorship(List<Match> matches) {
        for (Match match : matches) {
            // Rule 1: Mask Team Names (Replace last word with ***)
            match.setTeam1(maskString(match.getTeam1()));
            match.setTeam2(maskString(match.getTeam2()));

            // Rule 2: Redact Player of the Match
            match.setPlayerOfMatch("REDACTED");
        }
    }

    private static String maskString(String name) {
        if (name == null || !name.contains(" ")) return name + " ***";
        return name.substring(0, name.lastIndexOf(" ")) + " ***";
    }
}