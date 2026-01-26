package com.songvault;


import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SongReader {

    private static final Pattern FIELD_PATTERN =
            Pattern.compile("^(Title|Artist|Duration|Genre):\\s(.+)$");

    public static List<Song> readSongs(String folderPath) {

        List<Song> songs = new ArrayList<>();
        File folder = new File(folderPath);

        for (File file : folder.listFiles()) {
            if (!file.getName().endsWith(".txt")) continue;

            try (BufferedReader br =
                         new BufferedReader(new FileReader(file))) {

                Map<String, String> fields = new HashMap<>();
                String line;

                while ((line = br.readLine()) != null) {
                    Matcher m = FIELD_PATTERN.matcher(line);
                    if (m.matches()) {
                        fields.put(m.group(1), m.group(2));
                    }
                }

                if (fields.size() == 4) {
                    songs.add(new Song(
                            fields.get("Title"),
                            fields.get("Artist"),
                            fields.get("Duration"),
                            fields.get("Genre")
                    ));
                }

            } catch (IOException e) {
                // skip unreadable file
            }
        }
        return songs;
    }
}
