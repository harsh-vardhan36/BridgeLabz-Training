package com.scenariobased.eventtracker;

import java.util.List;


public class EventTrackerApp {

    public static void main(String[] args) {

        try {
            List<AuditEvent> events =
                    AuditScanner.scan(UserActions.class);

            JsonLogWriter.writeLogs(events, "audit-log.json");

            System.out.println("✅ Audit log generated successfully");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
