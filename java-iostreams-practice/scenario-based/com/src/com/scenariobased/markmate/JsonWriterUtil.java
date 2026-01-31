package com.scenariobased.markmate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.school.markmate.model.StudentMarksheet;

public class JsonWriterUtil {

    public static void writeToJson(List<StudentMarksheet> reports, String filePath)
            throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(filePath);
        gson.toJson(reports, writer);
        writer.close();
    }
}
