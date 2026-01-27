package com.annotation.markimpmethod;

import java.lang.reflect.Method;

public class AnnotationTest {
    public static void main(String[] args) {

        Class<Service> clazz = Service.class;

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(ImportantMethod.class)) {

                ImportantMethod imp =
                        method.getAnnotation(ImportantMethod.class);

                System.out.println(
                    "Method: " + method.getName() +
                    ", Level: " + imp.level()
                );
            }
        }
    }
}
