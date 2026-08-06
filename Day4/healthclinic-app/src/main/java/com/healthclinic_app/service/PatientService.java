package com.healthclinic_app.service;

import com.healthclinic_app.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientService {

    /**
     * Deletes a patient along with every bill and appointment that
     * references them, as a single atomic transaction. Without this,
     * a plain DELETE on patients would fail on the foreign key from
     * appointments (and appointments would fail on the FK from bills).
     * If any step fails, everything is rolled back and the patient is
     * left untouched.
     */
    public boolean deletePatientCascade(int patientId) {
        String deleteBills =
                "DELETE b FROM bills b JOIN appointments a ON b.appointmentId = a.appointmentId " +
                "WHERE a.patientId = ?";
        String deleteAppointments = "DELETE FROM appointments WHERE patientId = ?";
        String deletePatient = "DELETE FROM patients WHERE patientId = ?";

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            if (conn == null) {
                return false;
            }
            conn.setAutoCommit(false);

            try (PreparedStatement ps1 = conn.prepareStatement(deleteBills)) {
                ps1.setInt(1, patientId);
                ps1.executeUpdate();
            }

            try (PreparedStatement ps2 = conn.prepareStatement(deleteAppointments)) {
                ps2.setInt(1, patientId);
                ps2.executeUpdate();
            }

            int rows;
            try (PreparedStatement ps3 = conn.prepareStatement(deletePatient)) {
                ps3.setInt(1, patientId);
                rows = ps3.executeUpdate();
            }

            if (rows == 0) {
                conn.rollback();
                System.out.println("Patient not found. Nothing was deleted.");
                return false;
            }

            conn.commit();
            // trg_after_patient_delete fires as part of this commit and
            // records the deletion in patient_audit_log.
            System.out.println("Patient and all related appointments/bills deleted (transaction committed).");
            return true;

        } catch (SQLException e) {
            System.err.println("Transaction failed, rolling back: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
