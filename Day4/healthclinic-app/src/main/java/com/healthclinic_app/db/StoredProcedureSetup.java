package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Creates the stored procedures used by the app.
 *
 * Only two procedures exist in this project, deliberately:
 *
 * 1. sp_book_appointment
 *    Validates that the doctor and patient exist, inserts the
 *    appointment inside its own transaction, and hands back the new
 *    appointment id plus the bill amount (created by
 *    trg_after_appointment_insert). This is the one operation in the
 *    app where "insert a row" is not enough on its own - it needs
 *    validation + a guaranteed bill, so a procedure earns its keep here.
 *
 * 2. sp_doctor_revenue_report
 *    A read-only reporting procedure that joins doctors, appointments
 *    and bills to summarise a single doctor's workload and revenue.
 */
public class StoredProcedureSetup {

    public static void createProcedures() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("DROP PROCEDURE IF EXISTS sp_book_appointment");

            String bookAppointmentProc =
                    "CREATE PROCEDURE sp_book_appointment(" +
                    "    IN  p_doctorId INT, " +
                    "    IN  p_patientId INT, " +
                    "    IN  p_status VARCHAR(20), " +
                    "    IN  p_diagnosis VARCHAR(200), " +
                    "    OUT p_appointmentId INT, " +
                    "    OUT p_billAmount DOUBLE" +
                    ") " +
                    "BEGIN " +
                    "    DECLARE v_doctorExists INT DEFAULT 0; " +
                    "    DECLARE v_patientExists INT DEFAULT 0; " +
                    "    DECLARE EXIT HANDLER FOR SQLEXCEPTION " +
                    "    BEGIN " +
                    "        ROLLBACK; " +
                    "        RESIGNAL; " +
                    "    END; " +
                    "    SELECT COUNT(*) INTO v_doctorExists FROM doctors WHERE doctorId = p_doctorId; " +
                    "    SELECT COUNT(*) INTO v_patientExists FROM patients WHERE patientId = p_patientId; " +
                    "    IF v_doctorExists = 0 THEN " +
                    "        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Doctor does not exist'; " +
                    "    END IF; " +
                    "    IF v_patientExists = 0 THEN " +
                    "        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Patient does not exist'; " +
                    "    END IF; " +
                    "    START TRANSACTION; " +
                    "    INSERT INTO appointments (doctorId, patientId, appointmentTime, status, diagnosis) " +
                    "    VALUES (p_doctorId, p_patientId, NOW(), p_status, p_diagnosis); " +
                    "    SET p_appointmentId = LAST_INSERT_ID(); " +
                    "    SELECT amount INTO p_billAmount FROM bills WHERE appointmentId = p_appointmentId LIMIT 1; " +
                    "    COMMIT; " +
                    "END";
            stmt.executeUpdate(bookAppointmentProc);

            stmt.executeUpdate("DROP PROCEDURE IF EXISTS sp_doctor_revenue_report");

            String revenueReportProc =
                    "CREATE PROCEDURE sp_doctor_revenue_report(IN p_doctorId INT) " +
                    "BEGIN " +
                    "    SELECT " +
                    "        d.doctorId AS doctorId, " +
                    "        d.name AS doctorName, " +
                    "        COUNT(DISTINCT a.appointmentId) AS totalAppointments, " +
                    "        COALESCE(SUM(b.amount), 0) AS totalBilled, " +
                    "        COALESCE(SUM(CASE WHEN b.status = 'PAID' THEN b.amount ELSE 0 END), 0) AS totalCollected " +
                    "    FROM doctors d " +
                    "    LEFT JOIN appointments a ON a.doctorId = d.doctorId " +
                    "    LEFT JOIN bills b ON b.appointmentId = a.appointmentId " +
                    "    WHERE d.doctorId = p_doctorId " +
                    "    GROUP BY d.doctorId, d.name; " +
                    "END";
            stmt.executeUpdate(revenueReportProc);

        //    System.out.println("Stored procedures created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
