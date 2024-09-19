package com.carrental.view;
import com.carrental.Database.LoginData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPanel extends JFrame implements ActionListener
{
	
	
	
		JTextField usernameTF;
	    JPasswordField passTF;
		JButton login,cancel;
		public LoginPanel()
		{
			setTitle("Login Page ");
			Container c = getContentPane();
			c.setBackground(Color.cyan);
			c.setLayout(null);
			
			ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\Desktop\\CarRentalSystem\\CarRentalSystem\\resources\\car41.png");

	        JLabel l1 = new JLabel("Login Form");
			JLabel usernamel = new JLabel("Login Name");
			JLabel passl = new JLabel("Password ");
			JLabel image = new JLabel(icon);
			
			
			usernameTF = new JTextField();
			passTF = new JPasswordField();
			
			
			login = new JButton("Login");
			cancel = new JButton("CANCEL");
			
			Font f1 = new Font("arial",Font.BOLD,30);
			Font f2 = new Font("arial",Font.BOLD,20);
			l1.setBounds(550,50,550,100);
			l1.setFont(f1);
			usernamel.setFont(f2);
			passl.setFont(f2);
			
			usernameTF.setFont(f2);
			passTF.setFont(f2);
			
			login.setFont(f2);
			cancel.setFont(f2);
			
			usernamel.setBounds(450,150,150,30);
			passl.setBounds(450,210,150,30);
			image.setBounds(0,350,1350,350);
			
			usernameTF.setBounds(600,150,200,30);
			passTF.setBounds(600,210,200,30);
			
			
			login.setBounds(500,300,125,30);
			cancel.setBounds(700,300,125,30);
			
			c.add(l1);
			c.add(usernamel);
			c.add(usernameTF);
			c.add(passl);
			c.add(passTF);
			c.add(image);
		
			c.add(login);
			c.add(cancel);
			
			login.addActionListener(this);
			cancel.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e)
		{
			String name = usernameTF.getText();
			String pass = passTF.getText();
			if(e.getSource() == login) {
			LoginData LD = new LoginData();
		LD.cheackUser( name ,pass,login,e,cancel);
		
			}else if(e.getSource() == cancel)
		{
			System.exit(0);
		}
	
		}
		public static void main(String args[])
		{
			LoginPanel obj = new LoginPanel();
			obj.setSize(550,600);
			obj.setVisible(true);
			obj.setTitle("Login Page ");
			obj.setLocationRelativeTo(null);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        obj.setVisible(true);
	        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);

	                                    
		}



		
	}


