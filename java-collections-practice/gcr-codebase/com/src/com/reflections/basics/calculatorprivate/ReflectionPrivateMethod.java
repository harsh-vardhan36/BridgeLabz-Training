package com.reflections.basics.calculatorprivate;

import java.lang.reflect.Method;

public class ReflectionPrivateMethod {

    public static void main(String[] args) {

        try {
            // 1. Create object
            Calculator calculator = new Calculator();

            // 2. Get Class object
            Class<?> cls = calculator.getClass();

            // 3. Get private method
            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

            // 4. Break access control
            method.setAccessible(true);

            // 5. Invoke method
            Object result = method.invoke(calculator, 5, 4);

            // 6. Display result
            System.out.println("Multiplication Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
