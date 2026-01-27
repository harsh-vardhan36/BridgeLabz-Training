package com.annotation.customannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)   // Needed for Reflection
@Target(ElementType.METHOD)            // Used on methods
public @interface TaskInfo {
    String priority();
    String assignedTo();
}
