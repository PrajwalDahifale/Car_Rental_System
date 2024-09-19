package com.carrental.view;
    import javax.swing.*;

import com.carrental.Database.RegisterData;
import com.carrental.model.Register;

import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;
	public class RegisterPanel extends JFrame implements ActionListener
	{
		JTextField IdTF,NameTF,PhoneTF,EmailTF,AddTF;
	                  JPasswordField PassTF;
		JButton SaveB,CancelB;
		RegisterPanel()
		{
			setTitle("Registration Form");
			Container c = getContentPane();
			c.setBackground(Color.cyan);
			c.setLayout(null);
			
			ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\Desktop\\CarRentalSystem\\CarRentalSystem\\resources\\user1.png");
			JLabel l1 = new JLabel("Registration Form");
			JLabel IDl = new JLabel("ID");
			JLabel Namel = new JLabel("NAME");
			JLabel Passl = new JLabel("PASSWORD");
			JLabel Phonel = new JLabel("PHONENO");
			JLabel Email = new JLabel("EMAIL");
			JLabel Addl = new JLabel("ADDRESS");
			JLabel imagel = new JLabel(icon);
			
			IdTF = new JTextField();
			NameTF = new JTextField();
			PassTF = new JPasswordField();
			PhoneTF = new JTextField();
			EmailTF = new JTextField();
			AddTF = new JTextField();
			
			SaveB = new JButton("SAVE");
			CancelB = new JButton("CANCEL");
			
			Font f1 = new Font("arial",Font.BOLD,30);
			Font f2 = new Font("arial",Font.BOLD,20);
			l1.setBounds(500,20,400,50);
			l1.setFont(f1);
			IDl.setFont(f2);
			Namel.setFont(f2);
			Passl.setFont(f2);
			Phonel.setFont(f2);
			Email.setFont(f2);
			Addl.setFont(f2);
			
			IdTF.setFont(f2);
			NameTF.setFont(f2);
			PassTF.setFont(f2);
			PhoneTF.setFont(f2);
			EmailTF.setFont(f2);
			AddTF.setFont(f2);
			
			SaveB.setFont(f2);
			CancelB.setFont(f2);
			
			IDl.setBounds(200,100,150,30);
			Namel.setBounds(200,180,150,30);
			Passl.setBounds(200,260,150,30);
			Phonel.setBounds(200,340,150,30);
			Email.setBounds(200,420,150,30);
			Addl.setBounds(200,500,150,30);
			imagel.setBounds(600,50,700,500);
			
			IdTF.setBounds(350,100,250,30);
			NameTF.setBounds(350,180,250,30);
			PassTF.setBounds(350,260,250,30);
			PhoneTF.setBounds(350,340,250,30);
			EmailTF.setBounds(350,420,250,30);
			AddTF.setBounds(350,500,250,60);
			
			SaveB.setBounds(340,600,125,30);
			CancelB.setBounds(680,600,125,30);
			
			c.add(l1);
			c.add(IDl);
			c.add(IdTF);
			c.add(Namel);
			c.add(NameTF);
			c.add(Passl);
			c.add(PassTF);
			c.add(Phonel);
			c.add(PhoneTF);
			c.add(Email);
			c.add(EmailTF);
			c.add(Addl);
			c.add(AddTF);
			c.add(SaveB);
			c.add(CancelB);
			c.add(imagel);
			
			SaveB.addActionListener(this);
			CancelB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e)
		
		{
			Register reg = new Register();
			int Id = Integer.parseInt(IdTF.getText());
			reg.setId(Id);
			reg.setNameTF(NameTF.getText());
			reg.setPassTF(PassTF.getText());
			reg.setPhoneTF(PhoneTF.getText());
			reg.setEmailTF(EmailTF.getText());
			reg.setAddTF(AddTF.getText());
			
			if(e.getSource() == SaveB)
			{
				RegisterData rd = new  RegisterData(); 
				rd.saveDataRegister(reg);
				LoginPanel obj = new LoginPanel();
				obj.setSize(550,600);
				obj.setVisible(true);
				obj.setTitle("Login Page ");
				obj.setLocationRelativeTo(null);
				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        obj.setVisible(true);
		        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}else if(e.getSource() == CancelB)
			{
				System.exit(0);
				//dispose();
				
			}
		}
		public static void main(String args[])
		{
			RegisterPanel obj = new RegisterPanel();
			obj.setSize(550,600);
			obj.setVisible(true);
			obj.setTitle("Registration Form");
			obj.setLocationRelativeTo(null);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                                    
		}
	}


