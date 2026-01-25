package com.resumeanalyzer;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ResumeAnalyzer {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("\\b\\d{10}\\b");

    private static final List<String> KEYWORDS =
            Arrays.asList("Java", "Python", "Spring");

    public static Map<String, ResumeData> analyzeResumes(String folderPath) {
        Map<String, ResumeData> resumeMap = new HashMap<>();

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("Invalid folder path.");
            return resumeMap;
        }

        for (File file : files) {
            try {
                if (!file.getName().endsWith(".txt")) {
                    throw new UnsupportedOperationException("Invalid file format");
                }

                String content = readFile(file);

                String email = extract(content, EMAIL_PATTERN);
                String phone = extract(content, PHONE_PATTERN);

                if (email == null) {
                    throw new IllegalArgumentException("Email not found");
                }

                List<String> matched = extractKeywords(content);

                ResumeData data = new ResumeData(email, phone, matched);
                resumeMap.put(email, data);

            } catch (Exception e) {
                System.out.println("Skipping file: " + file.getName() +
                        " | Reason: " + e.getMessage());
            }
        }
        return resumeMap;
    }

    private static String readFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append(" ");
        }
        br.close();
        return sb.toString();
    }

    private static String extract(String content, Pattern pattern) {
        Matcher matcher = pattern.matcher(content);
        return matcher.find() ? matcher.group() : null;
    }

    private static List<String> extractKeywords(String content) {
        List<String> found = new ArrayList<>();
        for (String key : KEYWORDS) {
            if (content.toLowerCase().contains(key.toLowerCase())) {
                found.add(key);
            }
        }
        return found;
    }

    public static List<ResumeData> sortByKeywordCount(Map<String, ResumeData> map) {
        List<ResumeData> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b.getKeywordCount() - a.getKeywordCount());
        return list;
    }
}
