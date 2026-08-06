package com.healthclinic_app.dao;

import com.healthclinic_app.db.DBConnection;
import com.healthclinic_app.model.DoctorStats;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads from the doctor_stats table. That table is no longer computed
 * here with COUNT/GROUP BY - it is kept up to date automatically by
 * trg_after_appointment_insert every time a new appointment is booked,
 * which is the whole point of having the trigger.
 */
public class DoctorStatsDAO {

    public DoctorStats getStatsByDoctorId(int doctorId) {
        String sql = "SELECT doctorId, totalPatients FROM doctor_stats WHERE doctorId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    DoctorStats stats = new DoctorStats();
                    stats.setDoctorId(rs.getInt("doctorId"));
                    stats.setTotalPatients(rs.getInt("totalPatients"));
                    return stats;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DoctorStats> getAllDoctorStats() {
        List<DoctorStats> statsList = new ArrayList<>();
        String sql = "SELECT doctorId, totalPatients FROM doctor_stats ORDER BY doctorId";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                DoctorStats stats = new DoctorStats();
                stats.setDoctorId(rs.getInt("doctorId"));
                stats.setTotalPatients(rs.getInt("totalPatients"));
                statsList.add(stats);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return statsList;
    }
}
