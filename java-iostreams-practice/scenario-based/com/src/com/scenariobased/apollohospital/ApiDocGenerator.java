package com.scenariobased.apollohospital;

import java.lang.reflect.Method;

public class ApiDocGenerator {

    public static void generate(Method method) {

        if (method.isAnnotationPresent(PublicAPI.class)) {
            PublicAPI api = method.getAnnotation(PublicAPI.class);
            System.out.println("API Name   : " + method.getName());
            System.out.println("Type       : Public");
            System.out.println("Description: " + api.description());
            System.out.println("--------------------------------");
        }

        if (method.isAnnotationPresent(RequiresAuth.class)) {
            RequiresAuth auth = method.getAnnotation(RequiresAuth.class);
            System.out.println("API Name   : " + method.getName());
            System.out.println("Type       : Secured");
            System.out.println("Role       : " + auth.role());
            System.out.println("--------------------------------");
        }
    }
}
