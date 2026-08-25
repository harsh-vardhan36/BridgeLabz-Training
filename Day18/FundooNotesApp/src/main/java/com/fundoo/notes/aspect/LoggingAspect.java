package com.fundoo.notes.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Logs method entry, arguments, exit, and return value (or thrown
 * exception) for every method in the controller layer.
 *
 * Scope: com.fundoo.notes.controller package only (per project decision).
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // All methods in any class directly under the controller package.
    @Pointcut("execution(* com.fundoo.notes.controller..*(..))")
    public void controllerLayer() {}

    @Around("controllerLayer()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        log.info("Entering {}.{}() with args: {}", className, methodName, sanitizeArgs(args));

        try {
            Object result = joinPoint.proceed();
            log.info("Exiting {}.{}() with return: {}", className, methodName, result);
            return result;
        } catch (Throwable ex) {
            log.error("Exception in {}.{}() : {}", className, methodName, ex.getMessage());
            throw ex;
        }
    }

    /**
     * Masks the Authorization header value so raw JWTs never hit the logs;
     * every controller method here takes it as a @RequestHeader String.
     */
    private Object[] sanitizeArgs(Object[] args) {
        if (args == null) {
            return null;
        }
        Object[] copy = Arrays.copyOf(args, args.length);
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] instanceof String s && s.startsWith("Bearer ")) {
                copy[i] = "Bearer ****";
            }
        }
        return copy;
    }
}
