package com.scenariobased.apollohospital;

import java.lang.reflect.Method;

public class AnnotationScanner {

    public static void scan(Class<?> controllerClass) {

        Method[] methods = controllerClass.getDeclaredMethods();

        for (Method method : methods) {

            boolean hasPublic = method.isAnnotationPresent(PublicAPI.class);
            boolean hasAuth = method.isAnnotationPresent(RequiresAuth.class);

            if (!hasPublic && !hasAuth) {
                System.out.println(" Missing annotation on method: " + method.getName());
            } else {
                ApiDocGenerator.generate(method);
            }
        }
    }
}

