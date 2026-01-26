package com.junit.filetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileProcessorTest {

    FileProcessor processor = new FileProcessor();
    String filename = "testfile.txt";

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Path.of(filename));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        processor.writeToFile(filename, "Hello JUnit");

        String content = processor.readFromFile(filename);

        assertEquals("Hello JUnit", content);
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        processor.writeToFile(filename, "JUnit File Test");

        assertTrue(Files.exists(Path.of(filename)));
    }

    @Test
    void testReadNonExistingFileThrowsException() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("nofile.txt");
        });
    }
}
