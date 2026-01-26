package com.coderepocleaner;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class CodeAnalyzer {

    private static final Pattern BAD_METHOD_PATTERN =
            Pattern.compile("\\b[A-Z][a-zA-Z0-9]*\\s*\\(");

    private static final Pattern IMPORT_PATTERN =
            Pattern.compile("import\\s+([\\w\\.]+);");

    public static FileType analyze(Path file) {

        try {
            List<String> lines = Files.readAllLines(file);

            Set<String> imports = new HashSet<>();
            String content = String.join(" ", lines);

            for (String line : lines) {
                Matcher im = IMPORT_PATTERN.matcher(line);
                if (im.find()) {
                    imports.add(im.group(1));
                }
            }

            for (String imp : imports) {
                String className =
                        imp.substring(imp.lastIndexOf('.') + 1);
                if (!content.contains(className)) {
                    return FileType.WARNINGS; // unused import
                }
            }

            Matcher badMethod = BAD_METHOD_PATTERN.matcher(content);
            if (badMethod.find()) {
                return FileType.ERRORS; // naming violation
            }

            return FileType.VALID;

        } catch (IOException e) {
            return FileType.ERRORS;
        }
    }
}
