package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Creates the database triggers used by the app.
 *
 * Only two triggers exist in this project, deliberately:
 *
 * 1. trg_after_appointment_insert
 *    Fires AFTER INSERT ON appointments. Automatically generates the
 *    matching Bill (using the doctor's current fee) and keeps the
 *    doctor_stats table in sync, so the Java code never has to remember
 *    to do either of those things itself.
 *
 * 2. trg_after_patient_delete
 *    Fires AFTER DELETE ON patients. Writes a row to patient_audit_log
 *    so deleted patients leave a trace, even when the deletion happens
 *    as part of the cascading transaction in PatientService.
 */
public class TriggerSetup {

    public static void createTriggers() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("DROP TRIGGER IF EXISTS trg_after_appointment_insert");

            String appointmentTrigger =
                    "CREATE TRIGGER trg_after_appointment_insert " +
                    "AFTER INSERT ON appointments " +
                    "FOR EACH ROW " +
                    "BEGIN " +
                    "    DECLARE v_fees DOUBLE DEFAULT 0; " +
                    "    SELECT fees INTO v_fees FROM doctors WHERE doctorId = NEW.doctorId; " +
                    "    INSERT INTO bills (appointmentId, patientId, doctorId, amount, status, generatedAt) " +
                    "    VALUES (NEW.appointmentId, NEW.patientId, NEW.doctorId, v_fees, 'UNPAID', NOW()); " +
                    "    INSERT INTO doctor_stats (doctorId, totalPatients) " +
                    "    VALUES (NEW.doctorId, 1) " +
                    "    ON DUPLICATE KEY UPDATE totalPatients = totalPatients + 1; " +
                    "END";
            stmt.executeUpdate(appointmentTrigger);

            stmt.executeUpdate("DROP TRIGGER IF EXISTS trg_after_patient_delete");

            String patientDeleteTrigger =
                    "CREATE TRIGGER trg_after_patient_delete " +
                    "AFTER DELETE ON patients " +
                    "FOR EACH ROW " +
                    "BEGIN " +
                    "    INSERT INTO patient_audit_log (patientId, patientName, action) " +
                    "    VALUES (OLD.patientId, OLD.name, 'DELETED'); " +
                    "END";
            stmt.executeUpdate(patientDeleteTrigger);

          //  System.out.println("Triggers created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
