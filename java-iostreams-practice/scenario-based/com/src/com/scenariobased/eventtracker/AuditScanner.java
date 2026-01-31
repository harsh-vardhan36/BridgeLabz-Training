package com.scenariobased.eventtracker;

package com.enterprise.eventtracker.scanner;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;

import com.enterprise.eventtracker.annotation.AuditTrail;
import com.enterprise.eventtracker.model.AuditEvent;

public class AuditScanner {

    public static List<AuditEvent> scan(Class<?> clazz) {

        List<AuditEvent> events = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(AuditTrail.class)) {

                AuditTrail audit = method.getAnnotation(AuditTrail.class);

                AuditEvent event = new AuditEvent(
                        method.getName(),
                        audit.action(),
                        audit.severity(),
                        LocalDateTime.now()
                );

                events.add(event);
            }
        }
        return events;
    }
}
