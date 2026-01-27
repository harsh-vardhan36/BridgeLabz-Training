package com.annotation.cachingsystem;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class CacheExecutor {

    // Simple in-memory cache
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object execute(Object service, String methodName, Object... args)
            throws Exception {

        Class<?> clazz = service.getClass();
        Method method = clazz.getMethod(methodName, int.class);

        // Create unique cache key (method + parameters)
        String cacheKey = methodName + "_" + args[0];

        // Check if caching is enabled
        if (method.isAnnotationPresent(CacheResult.class)) {

            if (cache.containsKey(cacheKey)) {
                System.out.println("Returning cached result");
                return cache.get(cacheKey);
            }

            // Execute method
            Object result = method.invoke(service, args);

            // Store in cache
            cache.put(cacheKey, result);
            return result;
        }

        // If no annotation, execute normally
        return method.invoke(service, args);
    }
}
