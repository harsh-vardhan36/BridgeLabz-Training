package com.healthclinic_app.dao;

import com.healthclinic_app.db.DBConnection;
import com.healthclinic_app.model.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {

    // Create - normally bills are created automatically by
    // trg_after_appointment_insert, but a manual insert path is kept
    // here so Bill has a complete, independent CRUD surface too.
    public void insertBill(Bill bill) {
        String sql = "INSERT INTO bills(appointmentId, patientId, doctorId, amount, status, generatedAt) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bill.getAppointmentId());
            ps.setInt(2, bill.getPatientId());
            ps.setInt(3, bill.getDoctorId());
            ps.setDouble(4, bill.getAmount());
            ps.setString(5, bill.getStatus() == null ? "UNPAID" : bill.getStatus());
            ps.setTimestamp(6, bill.getGeneratedAt() == null
                    ? new Timestamp(System.currentTimeMillis()) : bill.getGeneratedAt());

            ps.executeUpdate();
            System.out.println("Bill inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read one
    public Bill getBillById(int billId) {
        String sql = "SELECT * FROM bills WHERE billId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, billId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bill getBillByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM bills WHERE appointmentId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Read many
    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        String sql = "SELECT * FROM bills ORDER BY billId";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                bills.add(mapRow(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }

    public List<Bill> getBillsByPatientId(int patientId) {
        List<Bill> bills = new ArrayList<>();
        String sql = "SELECT * FROM bills WHERE patientId = ? ORDER BY billId";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    bills.add(mapRow(rs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }

    // Update - change the status (e.g. mark PAID); paidAt is stamped
    // automatically when the new status is PAID, cleared otherwise.
    public void updateBillStatus(int billId, String status) {
        String sql = "UPDATE bills SET status = ?, paidAt = ? WHERE billId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            if ("PAID".equalsIgnoreCase(status)) {
                ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            } else {
                ps.setNull(2, Types.TIMESTAMP);
            }
            ps.setInt(3, billId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Bill status updated successfully!");
            } else {
                System.out.println("No bill found with that ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteBill(int billId) {
        String sql = "DELETE FROM bills WHERE billId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, billId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Bill deleted successfully!");
            } else {
                System.out.println("No bill found with that ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bill mapRow(ResultSet rs) throws SQLException {
        Bill bill = new Bill();
        bill.setBillId(rs.getInt("billId"));
        bill.setAppointmentId(rs.getInt("appointmentId"));
        bill.setPatientId(rs.getInt("patientId"));
        bill.setDoctorId(rs.getInt("doctorId"));
        bill.setAmount(rs.getDouble("amount"));
        bill.setStatus(rs.getString("status"));
        bill.setGeneratedAt(rs.getTimestamp("generatedAt"));
        bill.setPaidAt(rs.getTimestamp("paidAt"));
        return bill;
    }
}
