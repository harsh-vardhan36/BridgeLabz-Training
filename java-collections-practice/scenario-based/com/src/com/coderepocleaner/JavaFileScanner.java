package com.coderepocleaner;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class JavaFileScanner {

    public static List<Path> scan(String root) throws IOException {
        List<Path> javaFiles = new ArrayList<>();

        Files.walk(Paths.get(root))
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(javaFiles::add);

        return javaFiles;
    }
}
