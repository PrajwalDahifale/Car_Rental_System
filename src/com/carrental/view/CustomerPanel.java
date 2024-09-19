package com.carrental.view;
import javax.swing.*;

import com.carrental.Database.CustomerData;

//import com.carrental.model.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List.*;
//import java.util.Vector;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.carrental.model.Customer;
import com.carrental.model.Driver;
public class CustomerPanel extends JFrame implements ActionListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField IdTF,NameTF,PhoneTF,EmailTF,AddTF,AdharNOTF,SearchNameTF,LINCENSENOTF,tableTF;
    //JPasswordField PassTF;
JButton SaveB,CancelB,SearchB,NextB;
public String[] columnNames = {"id","name","aadhar","phone_no","license","address"};
 public DefaultTableModel model;
public JTable table;
public Container c;
ResultSet rs;
public JScrollPane scroll;
public CustomerPanel()
{

	c = getContentPane();
c.setBackground(Color.cyan);
c.setLayout(null);

ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\Desktop\\CarRentalSystem\\CarRentalSystem\\resources\\c.png");
JLabel l1 = new JLabel("Customer Details");
JLabel IDl = new JLabel("ID");
JLabel Namel = new JLabel("NAME");
JLabel AdharNOl = new JLabel("AADHAR-NO");
JLabel Phonel = new JLabel("PHONE-NO");
JLabel LicenseNol=new JLabel("LICENSE-NO");
JLabel Addl = new JLabel("ADDRESS");
JLabel imagel = new JLabel(icon);
JLabel SearchNamel = new JLabel("Search Customer Name ");

IdTF = new JTextField();
NameTF = new JTextField();
AdharNOTF = new JTextField();
PhoneTF = new JTextField();
SearchNameTF = new JTextField();
AddTF = new JTextField();
LINCENSENOTF= new JTextField();
tableTF = new JTextField();

SaveB = new JButton("SAVE");
CancelB = new JButton("CANCEL");
SearchB = new JButton("SEAECH");
NextB = new JButton("NEXT");

Font f1 = new Font("arial",Font.BOLD,30);
Font f2 = new Font("arial",Font.BOLD,20);
l1.setBounds(500,20,400,50);
l1.setFont(f1);
IDl.setFont(f2);
Namel.setFont(f2);
LicenseNol.setFont(f2);
AdharNOl.setFont(f2);
Phonel.setFont(f2);

SearchNamel.setFont(f2);
Addl.setFont(f2);

IdTF.setFont(f2);
NameTF.setFont(f2);
AdharNOTF.setFont(f2);
PhoneTF.setFont(f2);
LINCENSENOTF.setFont(f2);
SearchNameTF.setFont(f2);
AddTF.setFont(f2);
tableTF.setFont(f2);

SaveB.setFont(f2);
CancelB.setFont(f2);
NextB.setFont(f2);
SearchB.setFont(f2);


IDl.setBounds(800,100,150,30);
Namel.setBounds(800,180,150,30);
AdharNOl.setBounds(800,260,150,30);
Phonel.setBounds(800,340,150,30);
LicenseNol.setBounds(800, 420, 150,30);
SearchNamel.setBounds(20,450,800,30);
Addl.setBounds(800,500,150,30);
imagel.setBounds(10,50,750,390);

IdTF.setBounds(1000,100,250,30);
NameTF.setBounds(1000,180,250,30);
AdharNOTF.setBounds(1000,260,250,30);
PhoneTF.setBounds(1000,340,250,30);
LINCENSENOTF.setBounds(1000,420,250,30);
SearchNameTF.setBounds(300,450,300,30);
AddTF.setBounds(1000,500,250,60);
tableTF.setBounds(20,490,600,200);

SaveB.setBounds(770,600,125,30);
CancelB.setBounds(1200,600,125,30);
NextB.setBounds(1000,600,125,30);
SearchB.setBounds(610,450,125,30);


c.add(l1);
c.add(IDl);
c.add(IdTF);
c.add(Namel);
c.add(NameTF);
c.add(AdharNOl);
c.add(AdharNOTF);
c.add(Phonel);
c.add(PhoneTF);
c.add(LicenseNol);
c.add(LINCENSENOTF);
c.add(SearchNamel);
c.add(SearchNameTF);
c.add(Addl);
c.add(AddTF);
c.add(SaveB);
c.add(CancelB);
c.add(imagel);
c.add(SearchB);
c.add(NextB);
c.add(tableTF);

SaveB.addActionListener(this);
CancelB.addActionListener(this);
SearchB.addActionListener(this);
NextB.addActionListener(this);
}

public void actionPerformed(ActionEvent e)

{
	int Id = Integer.parseInt(IdTF.getText());
	Customer Cmo = new Customer(Id,
NameTF.getText(),
AdharNOTF.getText(),
PhoneTF.getText(),
SearchNameTF.getText(),
AddTF.getText()
);

if(e.getSource() == SaveB)
	{
	     CustomerData Cdata = new CustomerData();
	     Cdata.saveDataCustomer(Cmo);
//	     AdminPanel obj = new AdminPanel();
//	        obj.setSize(550, 600);
//	        obj.setVisible(true);
//	        obj.setTitle("Admin Panel");
//	        obj.setLocationRelativeTo(null);
//	        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }else if(e.getSource() == CancelB)
	{
		System.exit(0);
	}else if(e.getSource() == NextB)
{
		AdminPanel obj = new AdminPanel();
        obj.setSize(550, 600);
        obj.setVisible(true);
        obj.setTitle("Admin Panel");
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);   
} else if(e.getSource() == SearchB){ 
	CustomerData Cdata = new CustomerData();
    List<Customer> rs = Cdata.getCustomersByName(SearchNameTF.getText());
    showTableData(rs);
   
	
	}
		
}		

void showTableData(List<Customer> Customers) {
    try {
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"ID", "Name", "Aadhar", "Phone No", "License", "Address"};
        model.setColumnIdentifiers(columnNames);
        JTable resultTable = new JTable();
        resultTable.setModel(model);
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        resultTable.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(resultTable);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        for (Customer customer : Customers) {
            model.addRow(new Object[]{customer.getId(), customer.getNameTF(), customer.getAdharNOTF(), customer.getPhoneTF(), customer.getLINCENSENOTF(), customer.getAddTF()});
        }

        scroll.setBounds(20,490,600,200);
        c.add(scroll);
    } catch (Exception e1) {
        JOptionPane.showMessageDialog(this, "Exception: " + e1);
    }
}

//		public static void main(String args[])
//		{
//			 CustomerPanel obj = new CustomerPanel();
//			obj.setSize(550,600);
//			obj.setVisible(true);
//			obj.setTitle("Customer Details");
//			obj.setLocationRelativeTo(null);
//			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	                 obj.setVisible(true);
//	                                 obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
//
//	                                    
//		}

		
	}

	


