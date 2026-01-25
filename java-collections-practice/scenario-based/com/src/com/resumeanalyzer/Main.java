package com.resumeanalyzer;

import java.util.*;

public class Main{
    public static void main(String[] args) {

        String resumeFolder = "resumes"; // folder path

        Map<String, ResumeData> resumeMap =
                ResumeAnalyzer.analyzeResumes(resumeFolder);

        List<ResumeData> sortedCandidates =
                ResumeAnalyzer.sortByKeywordCount(resumeMap);

        System.out.println("\n--- Sorted Candidates ---");
        for (ResumeData r : sortedCandidates) {
            System.out.println(r);
        }
    }
}
