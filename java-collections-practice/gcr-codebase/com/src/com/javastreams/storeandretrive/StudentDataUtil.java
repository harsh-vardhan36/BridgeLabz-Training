package com.javastreams.storeandretrive;

import java.io.*;

public class StudentDataUtil {

    // Write student data (binary)
    public static void writeStudent(Student s, String fileName) {

        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(fileName))) {

            dos.writeInt(s.rollNumber);
            dos.writeUTF(s.name);
            dos.writeDouble(s.gpa);

            System.out.println("Student data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error while writing data");
        }
    }

    // Read student data (binary)
    public static void readStudent(String fileName) {

        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(fileName))) {

            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Student Data Retrieved:");
            System.out.println("Roll No: " + roll);
            System.out.println("Name   : " + name);
            System.out.println("GPA    : " + gpa);

        } catch (IOException e) {
            System.out.println("Error while reading data");
        }
    }
}
