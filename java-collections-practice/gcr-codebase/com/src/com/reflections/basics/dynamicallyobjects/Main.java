package com.reflections.basics.dynamicallyobjects;

import java.lang.reflect.Constructor;

public class Main{

    public static void main(String[] args) {

        try {
            // 1. Load class dynamically
            Class<?> cls = Class.forName("com.reflections.basics.dynamicallyobjects.Student");

            // 2. Get constructor
            Constructor<?> constructor =
                    cls.getDeclaredConstructor(String.class, int.class);

            // 3. Create object (NO new keyword)
            Object obj = constructor.newInstance("Harsh", 22);

            // 4. Use the object
            Student student = (Student) obj;
            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
