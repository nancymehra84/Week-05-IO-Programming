package com.io_programing.advanced_problems.csv_report_from_database;

import java.io.*;
import java.sql.*;

public class GenerateCSVFromDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String DB_USER = "muskan_015";
    private static final String DB_PASSWORD = "password";

    public static void exportToCSV(String fileName) {
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            while (rs.next()) {
                writer.write(rs.getInt("employee_id") + "," +
                        rs.getString("name") + "," +
                        rs.getString("department") + "," +
                        rs.getDouble("salary"));
                writer.newLine();
            }

            System.out.println("CSV report generated successfully: " + fileName);

        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String csvFile = "src/main/java/employeeReport.csv";
        exportToCSV(csvFile);
    }
}

