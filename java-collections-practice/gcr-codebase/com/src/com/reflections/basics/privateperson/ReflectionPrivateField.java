package com.reflections.basics.privateperson;

import java.lang.reflect.Field;

public class ReflectionPrivateField {

    public static void main(String[] args) {

        try {
            // 1. Create object
            Person person = new Person();

            // 2. Get Class object
            Class<?> cls = person.getClass();

            // 3. Access private field
            Field ageField = cls.getDeclaredField("age");

            // 4. Break encapsulation
            ageField.setAccessible(true);

            // 5. Modify value
            ageField.set(person, 25);

            // 6. Retrieve value
            int ageValue = (int) ageField.get(person);

            System.out.println("Age (via Reflection): " + ageValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
