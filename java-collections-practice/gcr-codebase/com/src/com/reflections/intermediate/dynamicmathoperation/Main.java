package com.reflections.intermediate.dynamicmathoperation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // 1. Create object
            MathOperations math = new MathOperations();

            // 2. Get user input
            System.out.print("Enter method name (add / subtract / multiply): ");
            String methodName = sc.next();

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            // 3. Get Class object
            Class<?> cls = math.getClass();

            // 4. Get method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);

            // 5. Invoke method
            Object result = method.invoke(math, a, b);

            // 6. Display result
            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
