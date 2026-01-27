package com.reflections.advance.dependencyreflection;

import java.lang.reflect.Field;

public class DIContainer {

    public static <T> T createObject(Class<T> clazz) {
        try {
            // Create object of requested class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Inject fields marked with @Inject
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {

                    Object dependency =
                            field.getType().getDeclaredConstructor().newInstance();

                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}