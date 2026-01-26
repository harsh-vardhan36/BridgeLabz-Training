package com.reflections.basics;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInspector {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter fully qualified class name: ");
        String className = sc.nextLine();

        try {
            // 1. Load class dynamically
            Class<?> cls = Class.forName(className);

            System.out.println("\n--- Class Name ---");
            System.out.println(cls.getName());

            // 2. Display Constructors
            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }

            // 3. Display Fields
            System.out.println("\n--- Fields ---");
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f);
            }

            // 4. Display Methods
            System.out.println("\n--- Methods ---");
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found. Please enter correct class name.");
        }

        sc.close();
        
    }
}