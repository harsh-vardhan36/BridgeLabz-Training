package com.healthclinic_app.dao;

import com.healthclinic_app.db.DBConnection;
import com.healthclinic_app.model.DoctorSpecialization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorSpecializationDAO {

    // Assign specialization to doctor
    public void addSpecializationToDoctor(DoctorSpecialization ds) {
        String sql = "INSERT INTO doctor_specializations(doctorId, spId) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, ds.getDoctorId());
            ps.setInt(2, ds.getSpId());
            ps.executeUpdate();
            System.out.println("Specialization assigned to doctor successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Remove specialization from doctor
    public void removeSpecializationFromDoctor(int doctorId, int spId) {
        String sql = "DELETE FROM doctor_specializations WHERE doctorId=? AND spId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ps.setInt(2, spId);
            ps.executeUpdate();
            System.out.println("Specialization removed from doctor successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get all specializations for a doctor
    public List<Integer> getSpecializationsByDoctor(int doctorId) {
        List<Integer> spIds = new ArrayList<>();
        String sql = "SELECT spId FROM doctor_specializations WHERE doctorId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                spIds.add(rs.getInt("spId"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return spIds;
    }

    // Get all doctors for a specialization
    public List<Integer> getDoctorsBySpecialization(int spId) {
        List<Integer> doctorIds = new ArrayList<>();
        String sql = "SELECT doctorId FROM doctor_specializations WHERE spId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, spId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                doctorIds.add(rs.getInt("doctorId"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorIds;
    }
}
