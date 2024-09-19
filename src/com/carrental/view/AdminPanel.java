package com.carrental.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AdminPanel extends JFrame implements ActionListener{

	JLabel bgimg;
	JTextArea header;
	JMenuItem addCustomer,addcar,addDriver,GenrateBill,view,edit,logOut;
	JMenu menu, submenu;  
    
	public AdminPanel() {
		
		setVisible(true);
		setSize(500,500);
		getContentPane().setLayout(null);
		
		
		
				
		JMenuBar mb=new JMenuBar();  
		
        menu=new JMenu("MENU"); 
        menu.setBackground(new Color(0, 128, 128));
        addCustomer=new JMenuItem("Add Customer");
        addCustomer.setBackground(Color.white);
        addCustomer.addActionListener(this);
        addcar=new JMenuItem("Add Car");
        addcar.setBackground(Color.white);
        addcar.addActionListener(this);
        addDriver=new JMenuItem("Add Driver");
        addDriver.setBackground(Color.white);
        addDriver.addActionListener(this);
        GenrateBill=new JMenuItem("Genrate Bill");
        GenrateBill.setBackground(Color.white);
        GenrateBill.addActionListener(this);

        logOut=new JMenuItem("LogOut");
        logOut.setBackground(Color.white);
        logOut.addActionListener(this);
        
        submenu=new JMenu("Profile");  

        submenu.add(logOut);
          
        menu.add(submenu);
        mb.add(menu); 
        mb.add(addCustomer);
        mb.add(addcar);
        mb.add(addDriver);
        mb.add(GenrateBill);
       
        mb.setBounds(10,10,1260,40);
       
		
        
        header=new JTextArea();
        header.setForeground(new Color(0, 139, 139));
		header.setBounds(0,0,1400,60);
		header.setBackground(new Color(0, 128, 128));
		header.setEditable(false);
		
		
		
		ImageIcon i11=new ImageIcon("library.jpg");
		Image img=i11.getImage().getScaledInstance(1400,800,Image.SCALE_SMOOTH);
		i11=new ImageIcon(img);
		bgimg=new JLabel("",i11,JLabel.CENTER);
		bgimg.setBounds(0,0,1400,800);
		getContentPane().add(bgimg);
		
		bgimg.add(mb);
		bgimg.add(header);
		
		
		         
	  
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==addCustomer)
		{
			CustomerPanel obj = new CustomerPanel();
			obj.setSize(550,600);
			obj.setVisible(true);
			obj.setTitle("Customer Details");
			obj.setLocationRelativeTo(null);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		             obj.setVisible(true);
		                             obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		}
		if(ae.getSource()==addcar)
		{
			
			 CarPanel carDetailsPage = new CarPanel();
		     carDetailsPage.setSize(1600, 800); // Increased size for better view
		     carDetailsPage.setVisible(true);
		     carDetailsPage.setTitle("Car Details");
		     carDetailsPage.setLocationRelativeTo(null);
		     carDetailsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
		
		if(ae.getSource()==addDriver)
		{
			
			 DriverPanel obj = new DriverPanel();
	        obj.setSize(550, 600);
	        obj.setVisible(true);
	        obj.setTitle("Driver Details");
	        obj.setLocationRelativeTo(null);
	        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
					
		}
		if(ae.getSource()==GenrateBill)
		{
			
			 BillPanel obj = new BillPanel();
		        obj.setSize(550, 600);
		        obj.setVisible(true);
		        obj.setTitle("Bill Details");
		        obj.setLocationRelativeTo(null);
		        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
					
		}
		
	}
	
	public static void main(String[] args) {
		
		new AdminPanel();
	}
}

