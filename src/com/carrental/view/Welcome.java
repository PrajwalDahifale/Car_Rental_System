package com.carrental.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener
{
	JButton Loginb,Registerb;
	public Welcome()
	{
		
		setSize(400,400);
	    setVisible(true);
		setTitle("Welcome To car rental System");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setBackground(Color.cyan);
		c.setLayout(null);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\Desktop\\CarRentalSystem\\CarRentalSystem\\resources\\carrental2.png");

		JLabel l2 = new JLabel("Welcome To Car Rental System");
		JLabel l3 = new JLabel("All Type Of Car Are Avilable");
		JLabel l4 = new JLabel(icon);
		Font f1 = new Font("Inter",Font.BOLD,40);
		Font f3 = new Font("Inter",Font.BOLD,30);
		l2.setBounds(400,50,750,100);
		l2.setFont(f1);
		l3.setBounds(500,100,880,230);
		l3.setFont(f3);
		l4.setBounds(0,0,1350,760);
		
		Loginb = new JButton("Login");
		Registerb = new JButton("Register");
		Font f2 = new Font("Inter",Font.BOLD,20);
		Loginb.setFont(f2);
		Registerb.setFont(f2);
		Loginb.setBounds(480,530,155,45);
		Registerb.setBounds(800,530,155,45);
		
		
		
		c.add(l2);
		c.add(l3);
		c.add(Loginb);
		c.add(Registerb);
		
		c.add(l4);
	
	Loginb.addActionListener(this);
	Registerb.addActionListener(this);
	
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == Loginb)
		{
			LoginPanel lf = new LoginPanel();
			lf.setVisible(true);
			lf.setExtendedState(JFrame.MAXIMIZED_BOTH);
			dispose();
		}
		
		if(e.getSource() == Registerb)
		{
			RegisterPanel reg = new RegisterPanel();
			reg.setVisible(true);
			reg.setExtendedState(JFrame.MAXIMIZED_BOTH);
			dispose();
		}
		 
	}

	
	
	
	
//public static void main(String args [])
//	{
//		Welcome w = new Welcome();
//		
//		
//		
//	}
}

