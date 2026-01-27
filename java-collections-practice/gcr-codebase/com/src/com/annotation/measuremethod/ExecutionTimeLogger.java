package com.annotation.measuremethod;

import java.lang.reflect.Method;

public class ExecutionTimeLogger {

    public static void main(String[] args) throws Exception {

        PerformanceService service = new PerformanceService();
        Class<?> clazz = service.getClass();

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();

                method.invoke(service);   // execute method

                long end = System.nanoTime();

                System.out.println(
                    method.getName() + " executed in " +
                    (end - start) + " ns"
                );
            }
        }
    }
}
