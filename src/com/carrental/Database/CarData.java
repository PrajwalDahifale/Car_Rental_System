package com.carrental.Database;

//CarDatabase.java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.carrental.model.*;
import com.carrental.model.Driver;

public class CarData {
	
	private static final String URL = "jdbc:mysql://localhost:3306/carrentalsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "Prajwal@12";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

 public void saveCar(Car car) throws SQLException, ClassNotFoundException {
     Connection con = connect();
     PreparedStatement pstmt = con.prepareStatement(
         "INSERT INTO car VALUES (?, ?, ?, ?, ?, ?, ?)"
     );
     pstmt.setInt(1, car.getCarId());
     pstmt.setString(2, car.getCarModel());
     pstmt.setString(3, car.getRent());
     pstmt.setString(4, car.getCarNumber());
     pstmt.setString(5, car.getChassisNumber());
     pstmt.setString(6, car.getType());
     pstmt.setString(7, car.getAverage());
     pstmt.executeUpdate();
     con.close();
 }

 public List<Car> getCarsByNO(String CarNo)   {
     List<Car> cars = new ArrayList<>();
     String query = "SELECT * FROM car WHERE carNumber = ?";
     try (Connection con =  connect();
          PreparedStatement pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)) {
System.out.println(CarNo);
         pstmt.setString(1, CarNo);
         ResultSet rs = pstmt.executeQuery();
        
         if(rs.next()) {
               rs.previous();
         while (rs.next()) {
             int id = rs.getInt("carId");
             String carModel = rs.getString("carModel");
             String rent = rs.getString("rent");
             String carNo = rs.getString("carNumber");
             String chassisNumber = rs.getString("chassisNumber");
             String type = rs.getString("type");
             String average = rs.getString("average");
             System.out.println(rs.getInt("carId"));

             Car car = new Car (id, carModel, rent, carNo,chassisNumber, type,  average);
             cars.add(car);
             System.out.println(cars);
         }
         }else {
         	
         	JOptionPane.showMessageDialog(null,"Record not found");
         }
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
     }
     return cars;
 }
}

