package com.javastreams.readuserinput;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputUtil {

    public static void takeInputAndSave(String fileName) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = null;

        try {
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            fw = new FileWriter(fileName);

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error while reading input or writing file");

        } finally {
            try {
                if (fw != null) fw.close();
                br.close();
            } catch (IOException e) {
                System.out.println("Error while closing resources");
            }
        }
    }
}
