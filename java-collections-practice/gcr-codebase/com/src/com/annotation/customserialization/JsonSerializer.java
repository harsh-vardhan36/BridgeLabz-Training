package com.annotation.customserialization;

import java.lang.reflect.Field;

class JsonSerializer {

    public static String toJson(Object obj) {

        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        boolean first = true;

        for (Field field : clazz.getDeclaredFields()) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);

                try {
                    Object value = field.get(obj);

                    if (!first) {
                        json.append(", ");
                    }

                    json.append("\"")
                        .append(annotation.name())
                        .append("\": ");

                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }

                    first = false;

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        json.append("}");
        return json.toString();
    }
}

