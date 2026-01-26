package com.coderepocleaner;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class RepoOrganizer {

    public static Map<FileType, List<File>> organize(List<Path> files) {

        Map<FileType, List<File>> map =
                new EnumMap<>(FileType.class);

        for (FileType t : FileType.values()) {
            map.put(t, new ArrayList<>());
        }

        for (Path p : files) {
            FileType type = CodeAnalyzer.analyze(p);
            map.get(type).add(p.toFile());
        }
        return map;
    }
}
