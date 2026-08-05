package com.healthclinic_app.dao;

import com.healthclinic_app.db.DBConnection;
import com.healthclinic_app.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // Insert patient
    public void insertPatient(Patient patient) {
        String sql = "INSERT INTO patients(name, age, gender, phone, address, joinedAt) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setTimestamp(6, patient.getJoinedAt());

            ps.executeUpdate();
            System.out.println("Patient inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get patient by ID
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE patientId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patientId"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setPhone(rs.getString("phone"));
                patient.setAddress(rs.getString("address"));
                patient.setJoinedAt(rs.getTimestamp("joinedAt"));
                return patient;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update patient
    public void updatePatient(Patient patient) {
        String sql = "UPDATE patients SET name=?, age=?, gender=?, phone=?, address=?, joinedAt=? WHERE patientId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setTimestamp(6, patient.getJoinedAt());
            ps.setInt(7, patient.getPatientId());

            ps.executeUpdate();
            System.out.println("Patient updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete patient
    public void deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE patientId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Patient deleted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patientId"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setPhone(rs.getString("phone"));
                patient.setAddress(rs.getString("address"));
                patient.setJoinedAt(rs.getTimestamp("joinedAt"));
                patients.add(patient);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }
}
