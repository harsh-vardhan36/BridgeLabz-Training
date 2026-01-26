package com.coderepocleaner;

import java.io.File;
import java.time.Instant;
import java.util.*;
import java.util.stream.*;

public class StreamFilters {

    public static List<File> largeFiles(List<File> files, long sizeKB) {
        return files.stream()
                .filter(f -> f.length() > sizeKB * 1024)
                .collect(Collectors.toList());
    }

    public static List<File> modifiedAfter(List<File> files, Instant date) {
        return files.stream()
                .filter(f ->
                        Instant.ofEpochMilli(f.lastModified())
                                .isAfter(date))
                .collect(Collectors.toList());
    }
}
