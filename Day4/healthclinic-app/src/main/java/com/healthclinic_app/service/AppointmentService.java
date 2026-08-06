package com.healthclinic_app.service;

import com.healthclinic_app.db.DBConnection;

import java.sql.*;

public class AppointmentService {

    /** Simple holder for what sp_book_appointment hands back. */
    public static class BookingResult {
        public final int appointmentId;
        public final double billAmount;

        public BookingResult(int appointmentId, double billAmount) {
            this.appointmentId = appointmentId;
            this.billAmount = billAmount;
        }
    }

    /**
     * Books an appointment through the sp_book_appointment stored procedure.
     * The procedure validates the doctor/patient exist, inserts the
     * appointment inside its own START TRANSACTION ... COMMIT block, and
     * the trg_after_appointment_insert trigger creates the matching bill.
     * We just read back the OUT parameters here.
     */
    public BookingResult bookAppointment(int doctorId, int patientId, String status, String diagnosis)
            throws SQLException {
        String call = "{call sp_book_appointment(?, ?, ?, ?, ?, ?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(call)) {

            cs.setInt(1, doctorId);
            cs.setInt(2, patientId);
            cs.setString(3, status);
            cs.setString(4, diagnosis);
            cs.registerOutParameter(5, Types.INTEGER);
            cs.registerOutParameter(6, Types.DOUBLE);

            cs.execute();

            int newAppointmentId = cs.getInt(5);
            double billAmount = cs.getDouble(6);
            return new BookingResult(newAppointmentId, billAmount);
        }
    }

    /**
     * Cancels an appointment and voids its bill as a single atomic unit,
     * managed on the Java side (not inside a procedure) to demonstrate
     * plain JDBC transaction control: manual commit/rollback across two
     * statements that must both succeed or both be undone.
     */
    public boolean cancelAppointment(int appointmentId) {
        String updateAppt = "UPDATE appointments SET status = 'CANCELLED' WHERE appointmentId = ?";
        String updateBill = "UPDATE bills SET status = 'CANCELLED', paidAt = NULL WHERE appointmentId = ?";

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            if (conn == null) {
                return false;
            }
            conn.setAutoCommit(false);

            try (PreparedStatement ps1 = conn.prepareStatement(updateAppt)) {
                ps1.setInt(1, appointmentId);
                int rows = ps1.executeUpdate();
                if (rows == 0) {
                    conn.rollback();
                    System.out.println("Appointment not found. Nothing to cancel.");
                    return false;
                }
            }

            try (PreparedStatement ps2 = conn.prepareStatement(updateBill)) {
                ps2.setInt(1, appointmentId);
                ps2.executeUpdate();
            }

            conn.commit();
            System.out.println("Appointment cancelled and bill voided (transaction committed).");
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
