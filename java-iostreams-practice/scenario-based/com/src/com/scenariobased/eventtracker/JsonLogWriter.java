package com.scenariobased.eventtracker;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonLogWriter {

    public static void writeLogs(List<AuditEvent> events, String filePath)
            throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter writer = new FileWriter(filePath);
        gson.toJson(events, writer);
        writer.close();
    }
}
