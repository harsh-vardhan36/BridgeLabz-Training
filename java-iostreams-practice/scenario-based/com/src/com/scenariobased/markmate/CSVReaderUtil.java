package com.scenariobased.markmate;

import java.io.*;
import java.util.*;

public class CSVReaderUtil {

    public static List<String[]> readCSV(String filePath) throws IOException {

        List<String[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("marks.csv"));
        String line;

        while ((line = br.readLine()) != null) {
            data.add(line.split(","));
        }

        br.close();
        return data;
    }
}
