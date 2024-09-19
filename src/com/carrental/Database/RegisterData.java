package com.carrental.Database;

import java.sql.*;

import javax.swing.*;

import com.carrental.model.Register;
import com.carrental.view.LoginPanel;

public class RegisterData {
	
	 private static final String URL = "jdbc:mysql://localhost:3306/carrentalsystem";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Prajwal@12";
	
	public void saveDataRegister(Register reg) {
		
		

		  
		        String query = "INSERT INTO admin VALUES(?, ?, ?,?,?,?)";

		        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		             PreparedStatement statement = connection.prepareStatement(query)) {

		            statement.setInt(1, reg.getId());
		            statement.setString(2, reg.getNameTF());
		            statement.setString(3, reg.getPassTF());
		            statement.setString(4,reg.getPhoneTF());
		            statement.setString(5,reg.getEmailTF());
		            statement.setString(6,reg.getAddTF());
		            
		            statement.executeUpdate();

		            JOptionPane.showMessageDialog(null,"Register Successfully : ");
					connection.close();
					LoginPanel obj=new LoginPanel();
		            obj.setVisible(true);
		            obj.setExtendedState(JFrame.MAXIMIZED_BOTH);

				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Exception : "+e1);
					
				}
		
	}

}

