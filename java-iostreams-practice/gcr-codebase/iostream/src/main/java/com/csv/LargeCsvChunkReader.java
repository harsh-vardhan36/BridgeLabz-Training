package com.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LargeCsvChunkReader {

    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "D:/data/large_students.csv"; // large CSV path
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean isHeader = true;
            List<String> chunk = new ArrayList<>(CHUNK_SIZE);

            while ((line = br.readLine()) != null) {

                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                chunk.add(line);

                // Process when chunk is full
                if (chunk.size() == CHUNK_SIZE) {
                    totalRecords += processChunk(chunk);
                    chunk.clear(); // free memory
                }
            }

            // Process remaining lines
            if (!chunk.isEmpty()) {
                totalRecords += processChunk(chunk);
            }

            System.out.println("Total records processed: " + totalRecords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int processChunk(List<String> chunk) {
        // Example processing: just count lines
        System.out.println("Processed chunk of size: " + chunk.size());
        return chunk.size();
    }
}
