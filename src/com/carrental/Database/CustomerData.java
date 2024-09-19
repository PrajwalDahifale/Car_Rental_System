package com.carrental.Database;
import com.carrental.view.CustomerPanel;
import com.carrental.view.DriverPanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carrental.model.Customer;
//import com.mysql.cj.xdevapi.Statement;
import com.carrental.model.Driver;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import com.carrental.model.*;
//import java.awt.*;
//import java.awt.event.*;
//
//import javax.swing.table.DefaultTableModel;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List.*;
//
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;


public class CustomerData {
	
	
	 public DefaultTableModel mode;
	public JTable table;
	

	public JScrollPane scroll;
	
	private static final String URL = "jdbc:mysql://localhost:3306/carrentalsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "Prajwal@12";
    static ResultSet rs;
    String[] columnNames = {"id","name","aadhar","phone_no","license","address"};
    
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

public void saveDataCustomer(Customer Cmo) {
	String query = "INSERT INTO customer VALUES(?, ?, ?,?,?,?)";

	        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
	             PreparedStatement statement = connection.prepareStatement(query)) {

	            statement.setInt(1, Cmo.getId());
	            statement.setString(2, Cmo.getNameTF());
	            statement.setString(3, Cmo.getAdharNOTF());
	            statement.setString(4,Cmo.getPhoneTF());
	            statement.setString(5,Cmo.getLINCENSENOTF());
	            statement.setString(6,Cmo.getAddTF());
	            
	            statement.executeUpdate();

	            JOptionPane.showMessageDialog(null,"Data Save Successfully : ");
				connection.close();
			 DriverPanel obj = new DriverPanel();
		        obj.setSize(550, 600);
		        obj.setVisible(true);
		        obj.setTitle("Driver Details");
		        obj.setLocationRelativeTo(null);
		        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);

			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"Exception : "+e1);
				
			}
	
}

public List<Customer> getCustomersByName(String name) {
    List<Customer> Customers = new ArrayList<>();
    String query = "SELECT * FROM customer WHERE name = ?";
    try (Connection con = connect();
         PreparedStatement pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
rs.previous();
        while (rs.next()) {
            int id = rs.getInt("id");
            String Name = rs.getString("name");
            String aadhar = rs.getString("aadhar");
            String phoneNo = rs.getString("phone_no");
            String license = rs.getString("license");
            String address = rs.getString("address");

            Customer customer = new Customer(id, Name, aadhar, phoneNo, license, address);
            Customers.add(customer);
        }
        }else {
        	
        	JOptionPane.showMessageDialog(null,"Record not found");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
    }
    return Customers;
}

}

