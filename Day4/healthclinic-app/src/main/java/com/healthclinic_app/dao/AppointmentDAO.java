package com.healthclinic_app.dao;

import com.healthclinic_app.db.DBConnection;
import com.healthclinic_app.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    // Insert appointment
    public void insertAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments(doctorId, patientId, appointmentTime, status, diagnosis) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointment.getDoctorId());
            ps.setInt(2, appointment.getPatientId());
            ps.setTimestamp(3, appointment.getAppointmentTime());
            ps.setString(4, appointment.getStatus());
            ps.setString(5, appointment.getDiagnosis());

            ps.executeUpdate();
            System.out.println("Appointment inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get appointment by ID
    public Appointment getAppointmentById(int id) {
        String sql = "SELECT * FROM appointments WHERE appointmentId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointmentId"));
                appointment.setDoctorId(rs.getInt("doctorId"));
                appointment.setPatientId(rs.getInt("patientId"));
                appointment.setAppointmentTime(rs.getTimestamp("appointmentTime"));
                appointment.setStatus(rs.getString("status"));
                appointment.setDiagnosis(rs.getString("diagnosis"));
                return appointment;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update appointment
    public void updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointments SET doctorId=?, patientId=?, appointmentTime=?, status=?, diagnosis=? WHERE appointmentId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointment.getDoctorId());
            ps.setInt(2, appointment.getPatientId());
            ps.setTimestamp(3, appointment.getAppointmentTime());
            ps.setString(4, appointment.getStatus());
            ps.setString(5, appointment.getDiagnosis());
            ps.setInt(6, appointment.getAppointmentId());

            ps.executeUpdate();
            System.out.println("Appointment updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete appointment
    public void deleteAppointment(int id) {
        String sql = "DELETE FROM appointments WHERE appointmentId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Appointment deleted successfully!");
            } else {
                System.out.println("No appointment found with that ID.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Cannot delete this appointment: it still has a bill on record. " +
                    "Delete the bill first, or use Cancel Appointment instead.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get all appointments for a given doctor
    public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE doctorId = ? ORDER BY appointmentId";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    appointments.add(mapRow(rs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointments;
    }

    // Get all appointments for a given patient
    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patientId = ? ORDER BY appointmentId";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    appointments.add(mapRow(rs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointments;
    }

    private Appointment mapRow(ResultSet rs) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getInt("appointmentId"));
        appointment.setDoctorId(rs.getInt("doctorId"));
        appointment.setPatientId(rs.getInt("patientId"));
        appointment.setAppointmentTime(rs.getTimestamp("appointmentTime"));
        appointment.setStatus(rs.getString("status"));
        appointment.setDiagnosis(rs.getString("diagnosis"));
        return appointment;
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointmentId"));
                appointment.setDoctorId(rs.getInt("doctorId"));
                appointment.setPatientId(rs.getInt("patientId"));
                appointment.setAppointmentTime(rs.getTimestamp("appointmentTime"));
                appointment.setStatus(rs.getString("status"));
                appointment.setDiagnosis(rs.getString("diagnosis"));
                appointments.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
