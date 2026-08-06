package com.healthclinic_app.dao;

import com.healthclinic_app.db.DBConnection;
import com.healthclinic_app.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    // Insert a new doctor
    public void insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors(name, phone, email, experienceYears, fees, joinedAt) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getPhone());
            ps.setString(3, doctor.getEmail());
            ps.setInt(4, doctor.getExperienceYears());
            ps.setDouble(5, doctor.getFees());
            ps.setTimestamp(6, doctor.getJoinedAt());

            ps.executeUpdate();
            System.out.println("Doctor inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Retrieve doctor by ID
    public Doctor getDoctorById(int id) {
        String sql = "SELECT * FROM doctors WHERE doctorId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctorId"));
                doctor.setName(rs.getString("name"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setEmail(rs.getString("email"));
                doctor.setExperienceYears(rs.getInt("experienceYears"));
                doctor.setFees(rs.getDouble("fees"));
                doctor.setJoinedAt(rs.getTimestamp("joinedAt"));
                return doctor;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update doctor
    public void updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctors SET name=?, phone=?, email=?, experienceYears=?, fees=?, joinedAt=? WHERE doctorId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getPhone());
            ps.setString(3, doctor.getEmail());
            ps.setInt(4, doctor.getExperienceYears());
            ps.setDouble(5, doctor.getFees());
            ps.setTimestamp(6, doctor.getJoinedAt());
            ps.setInt(7, doctor.getDoctorId());

            ps.executeUpdate();
            System.out.println("Doctor updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete doctor
    public void deleteDoctor(int id) {
        String sql = "DELETE FROM doctors WHERE doctorId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Doctor deleted successfully!");
            } else {
                System.out.println("No doctor found with that ID.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Cannot delete this doctor: they still have appointments, " +
                    "bills or stats on record. Cancel/delete those first.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctorId"));
                doctor.setName(rs.getString("name"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setEmail(rs.getString("email"));
                doctor.setExperienceYears(rs.getInt("experienceYears"));
                doctor.setFees(rs.getDouble("fees"));
                doctor.setJoinedAt(rs.getTimestamp("joinedAt"));
                doctors.add(doctor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
