package com.annotation.rolebasedaccess;

import java.lang.reflect.Method;

public class RoleSecurityManager {

    public static void main(String[] args) throws Exception {

        // 🔹 Try with USER role
        UserContext.setRole("USER");
        executeSecuredMethod(new AdminService());

        System.out.println("------------------");

        // 🔹 Try with ADMIN role
        UserContext.setRole("ADMIN");
        executeSecuredMethod(new AdminService());
    }

    private static void executeSecuredMethod(Object service) throws Exception {

        Class<?> clazz = service.getClass();

        if (clazz.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);

            if (!roleAllowed.value().equals(UserContext.getRole())) {
                System.out.println("Access Denied!");
                return;
            }
        }

        // Access granted
        Method method = clazz.getDeclaredMethod("performAdminTask");
        method.invoke(service);
    }
}
