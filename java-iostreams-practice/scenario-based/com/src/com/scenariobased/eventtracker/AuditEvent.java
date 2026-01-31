package com.scenariobased.eventtracker;

import java.time.LocalDateTime;

public class AuditEvent {

    private String methodName;
    private String action;
    private String severity;
    private LocalDateTime timestamp;

    public AuditEvent(String methodName, String action,
                      String severity, LocalDateTime timestamp) {
        this.methodName = methodName;
        this.action = action;
        this.severity = severity;
        this.timestamp = timestamp;
    }
}
