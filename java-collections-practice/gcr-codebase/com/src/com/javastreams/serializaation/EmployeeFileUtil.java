package com.javastreams.serializaation;

import java.io.*;
import java.util.List;

public class EmployeeFileUtil {

    // Serialize (Save)
    public static void saveEmployees(List<Employee> employees, String fileName) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(employees);
            System.out.println("Employees saved successfully!");

        } catch (IOException e) {
            System.out.println("Error while saving employees");
        }
    }

  
    public static void readEmployees(String fileName) {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            List<Employee> employees = (List<Employee>) ois.readObject();

            System.out.println("Employees retrieved from file:");
            for (Employee e : employees) {
                System.out.println(e);
            }

        } catch (IOException e) {
            System.out.println("Error while reading file");
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found");
        }
    }
}
