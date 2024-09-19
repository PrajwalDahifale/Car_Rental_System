package com.carrental.Database;
import com.carrental.model.Driver;
import com.carrental.view.CarPanel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DriverData {
	private static final String URL = "jdbc:mysql://localhost:3306/carrentalsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "Prajwal@12";
  
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void saveDriver(Driver driver) {
        String query = "INSERT INTO driver (id, name, aadhar, phone_no, license, address) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, driver.getId());
            pstmt.setString(2, driver.getName());
            pstmt.setString(3, driver.getAadhar());
            pstmt.setString(4, driver.getPhoneNo());
            pstmt.setString(5, driver.getLicense());
            pstmt.setString(6, driver.getAddress());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data saved successfully.");
//            CarPanel carDetailsPage = new CarPanel();
//            carDetailsPage.setSize(1600, 800); // Increased size for better view
//            carDetailsPage.setVisible(true);
//            carDetailsPage.setTitle("Car Details");
//            carDetailsPage.setLocationRelativeTo(null);
//            carDetailsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }

    public List<Driver> getDriversByName(String name) {
        List<Driver> drivers = new ArrayList<>();
        String query = "SELECT * FROM driver WHERE name = ?";
        try (Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
              rs.previous();
            while (rs.next()) {
                int id = rs.getInt("id");
                String DriverName = rs.getString("name");
                String aadhar = rs.getString("aadhar");
                String phoneNo = rs.getString("phone_no");
                String license = rs.getString("license");
                String address = rs.getString("address");

                Driver driver = new Driver(id, DriverName, aadhar, phoneNo, license, address);
                drivers.add(driver);
            }
            }else {
            	
            	JOptionPane.showMessageDialog(null,"Record not found");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        return drivers;
    }

}

