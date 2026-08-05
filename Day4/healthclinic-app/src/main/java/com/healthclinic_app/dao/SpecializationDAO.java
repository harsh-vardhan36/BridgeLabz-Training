package com.healthclinic_app.dao;

import com.healthclinic_app.db.DBConnection;
import com.healthclinic_app.model.Specialization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecializationDAO {

    // Insert specialization
    public void insertSpecialization(Specialization sp) {
        String sql = "INSERT INTO specializations(specialization) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sp.getSpecialization());
            ps.executeUpdate();
            System.out.println("Specialization inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get specialization by ID
    public Specialization getSpecializationById(int id) {
        String sql = "SELECT * FROM specializations WHERE spId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Specialization sp = new Specialization();
                sp.setSpId(rs.getInt("spId"));
                sp.setSpecialization(rs.getString("specialization"));
                return sp;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update specialization
    public void updateSpecialization(Specialization sp) {
        String sql = "UPDATE specializations SET specialization=? WHERE spId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sp.getSpecialization());
            ps.setInt(2, sp.getSpId());
            ps.executeUpdate();
            System.out.println("Specialization updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete specialization
    public void deleteSpecialization(int id) {
        String sql = "DELETE FROM specializations WHERE spId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Specialization deleted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get all specializations
    public List<Specialization> getAllSpecializations() {
        List<Specialization> list = new ArrayList<>();
        String sql = "SELECT * FROM specializations";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Specialization sp = new Specialization();
                sp.setSpId(rs.getInt("spId"));
                sp.setSpecialization(rs.getString("specialization"));
                list.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
