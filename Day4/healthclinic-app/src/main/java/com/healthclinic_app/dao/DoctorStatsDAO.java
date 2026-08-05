package com.healthclinic_app.dao;

import com.healthclinic_app.db.DBConnection;
import com.healthclinic_app.model.DoctorStats;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorStatsDAO {

    // If using a view, query directly
    public DoctorStats getStatsByDoctorId(int doctorId) {
        String sql = "SELECT doctorId, COUNT(patientId) AS totalPatients " +
                     "FROM appointments WHERE doctorId=? GROUP BY doctorId";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                DoctorStats stats = new DoctorStats();
                stats.setDoctorId(rs.getInt("doctorId"));
                stats.setTotalPatients(rs.getInt("totalPatients"));
                return stats;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get stats for all doctors
    public List<DoctorStats> getAllDoctorStats() {
        List<DoctorStats> statsList = new ArrayList<>();
        String sql = "SELECT doctorId, COUNT(patientId) AS totalPatients " +
                     "FROM appointments GROUP BY doctorId";
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
