package com.healthclinic_app.service;

import com.healthclinic_app.db.DBConnection;
import com.healthclinic_app.model.DoctorRevenueReport;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportService {

    /** Calls sp_doctor_revenue_report and maps the single result row. */
    public DoctorRevenueReport getDoctorRevenueReport(int doctorId) throws SQLException {
        String call = "{call sp_doctor_revenue_report(?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(call)) {

            cs.setInt(1, doctorId);
            boolean hasResultSet = cs.execute();

            if (hasResultSet) {
                try (ResultSet rs = cs.getResultSet()) {
                    if (rs.next()) {
                        DoctorRevenueReport report = new DoctorRevenueReport();
                        report.setDoctorId(rs.getInt("doctorId"));
                        report.setDoctorName(rs.getString("doctorName"));
                        report.setTotalAppointments(rs.getInt("totalAppointments"));
                        report.setTotalBilled(rs.getDouble("totalBilled"));
                        report.setTotalCollected(rs.getDouble("totalCollected"));
                        return report;
                    }
                }
            }
        }
        return null;
    }
}
