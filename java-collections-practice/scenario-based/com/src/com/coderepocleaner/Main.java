package com.coderepocleaner;

import java.nio.file.*;
import java.time.Instant;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {

        List<Path> files =
                JavaFileScanner.scan("src");

        Map<FileType, List<java.io.File>> result =
                RepoOrganizer.organize(files);

        result.forEach((k, v) ->
                System.out.println(k + " → " + v.size()));

        List<java.io.File> bigFiles =
                StreamFilters.largeFiles(
                        result.get(FileType.WARNINGS), 50);

        System.out.println("Large warning files: " + bigFiles.size());
    }
}

