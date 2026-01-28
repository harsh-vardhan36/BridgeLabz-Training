package com.json.iplSensorAnalyzer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.*;
import java.util.*;

public class IPLAnalyzer {
    private static final ObjectMapper jsonMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    ObjectMapper jsonMapper1 = new ObjectMapper()
    	    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    @JsonProperty("score")
    private String score;

    // Add getter and setter  

    public static void main(String[] args) {
        try {
            // --- Process JSON ---
            List<Match> jsonMatches = Arrays.asList(jsonMapper.readValue(new File("src/main/java/jsonData/resources/ipl_input.json"), Match[].class));
            CensorService.applyCensorship(jsonMatches);
            jsonMapper.writeValue(new File("src/main/java/jsonData/resources/ipl_censored.json"), jsonMatches);
            System.out.println(" JSON Censorship Complete.");

            // --- Process CSV ---
            List<Match> csvMatches = new CsvToBeanBuilder<Match>(new FileReader("src/main/java/jsonData/resources/ipl_input.csv"))
                    .withType(Match.class).build().parse();
            CensorService.applyCensorship(csvMatches);
            
            try (Writer writer = new FileWriter("src/main/java/jsonData/resources/ipl_censored.csv")) {
                StatefulBeanToCsv<Match> beanToCsv = new StatefulBeanToCsvBuilder<Match>(writer).build();
                beanToCsv.write(csvMatches);
            }
            System.out.println(" CSV Censorship Complete.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}