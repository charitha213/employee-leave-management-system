package com.klef.jfsd.springboot.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaveApplicationModel {

    public boolean applyLeave(String leaveReason, String detailedExplanation, String leaveType, String startDate, String endDate) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String dbUsername = "your_database_username";
        String dbPassword = "your_database_password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            String sql = "INSERT INTO leave_applications (leave_reason, detailed_explanation, leave_type, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, leaveReason);
                statement.setString(2, detailedExplanation);
                statement.setString(3, leaveType);
                statement.setString(4, startDate);
                statement.setString(5, endDate);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
