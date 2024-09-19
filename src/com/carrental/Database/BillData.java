package com.carrental.Database;

import java.sql.*;

public class BillData {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    // Establish connection to MySQL
    public BillData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental", "username", "password"); // Replace with your DB details
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch car details based on car number
    public ResultSet searchCarByNumber(String carNo) {
        try {
            String query = "SELECT * FROM cars WHERE car_no = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, carNo);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Save bill details to the database
    public void saveBill(String billNo, String billDate, String type, int totalKm, double amount, double discount, double total, String carNo, int customerId) {
        try {
            String query = "INSERT INTO bills (bill_no, bill_date, type, total_km, amount, discount, total, car_no, customer_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, billNo);
            ps.setString(2, billDate);
            ps.setString(3, type);
            ps.setInt(4, totalKm);
            ps.setDouble(5, amount);
            ps.setDouble(6, discount);
            ps.setDouble(7, total);
            ps.setString(8, carNo);
            ps.setInt(9, customerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

