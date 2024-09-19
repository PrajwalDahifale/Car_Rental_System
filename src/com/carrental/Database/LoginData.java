package com.carrental.Database;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.carrental.view.AdminPanel;
import com.carrental.view.CustomerPanel;

public class LoginData {
	

	public  void cheackUser(String username , String password,JButton login,ActionEvent e,JButton cancel) {
		
		if(e.getSource() == login)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root","Prajwal@12");
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from admin where name = '"+username+"' and pass = '"+password+"'");
				
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null, "Login sucessfull  ");
					
					AdminPanel obj = new AdminPanel();
						obj.setSize(550,600);
						obj.setVisible(true);
						obj.setTitle("Admin Panel");
						obj.setLocationRelativeTo(null);
						obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				                 obj.setVisible(true);
				                                 obj.setExtendedState(JFrame.MAXIMIZED_BOTH);

				}else
				{
					JOptionPane.showMessageDialog(null,"Invalid User Name And Password  ");
				}
				
				con.close();
				
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"Exception : "+e1);
				
			}
		}
		if(e.getSource() == cancel)
		{
			System.exit(0);
		}
		
	}
	
}

