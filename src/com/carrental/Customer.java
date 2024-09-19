package com.carrental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Customer extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String URL = "jdbc:mysql://localhost:3306/carrentalsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "Prajwal@12";

	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
                   
	JButton b1,b2,b3,b4;
	JTable table;
	ResultSet rs;
	String[] columnNames = {"id","name","aadhar","phone_no","license","address"};
	Container c;

				
	Customer()
	{
		 c = getContentPane();
		c.setBackground(Color.cyan);
		c.setLayout(null);
		
		ImageIcon icon = new ImageIcon("C:/Users/My PC/Desktop/project/Resources/c.png");
		
		JLabel l1 = new JLabel("Customer Details");
		JLabel l2 = new JLabel("ID");
		JLabel l3 = new JLabel("NAME");
		JLabel l4 = new JLabel("AADHAR_NO");
		JLabel l5 = new JLabel("PHONENO");
		JLabel l6 = new JLabel("LICENSE_NO");
		JLabel l7 = new JLabel("ADDRESS");
		JLabel l8 = new JLabel(icon);
		JLabel l9 = new JLabel("Search Customer Name ");
		
		
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		tf7 = new JTextField();
		tf8 = new JTextField();
		
		b1 = new JButton("SAVE");
		b2 = new JButton("NEXT");
		b3 = new JButton("EXIT");
		b4 = new JButton("SEARCH");
		
		Font f1 = new Font("arial",Font.BOLD,30);
		Font f2 = new Font("arial",Font.BOLD,20);
		l1.setBounds(500,20,400,50);
		l1.setFont(f1);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		l6.setFont(f2);
		l7.setFont(f2);
		l9.setFont(f2);
		
		tf1.setFont(f2);
		tf2.setFont(f2);
		tf3.setFont(f2);
		tf4.setFont(f2);
		tf5.setFont(f2);
		tf6.setFont(f2);
		tf7.setFont(f2);
		tf8.setFont(f2);
		
		b1.setFont(f2);
		b2.setFont(f2);
		b3.setFont(f2);
		b4.setFont(f2);
		
		l2.setBounds(800,100,150,30);
		l3.setBounds(800,180,150,30);
		l4.setBounds(800,260,150,30);
		l5.setBounds(800,340,150,30);
		l6.setBounds(800,420,150,30);
		l7.setBounds(800,500,150,30);
		l8.setBounds(0,50,750,390);
		l9.setBounds(20,450,800,30);
		
		tf1.setBounds(1000,100,250,30);
		tf2.setBounds(1000,180,250,30);
		tf3.setBounds(1000,260,250,30);
		tf4.setBounds(1000,340,250,30);
		tf5.setBounds(1000,420,250,30);
		tf6.setBounds(1000,500,250,60);
		tf7.setBounds(250,450,300,30);
		tf8.setBounds(20,490,600,200);
		
		b1.setBounds(770,600,125,30);
		b2.setBounds(1000,600,125,30);
		b3.setBounds(1200,600,125,30);
		b4.setBounds(600,450,125,30);
		
		c.add(l1);
		c.add(l2);
		c.add(tf1);
		c.add(l3);
		c.add(tf2);
		c.add(l4);
		c.add(tf3);
		c.add(l5);
		c.add(tf4);
		c.add(l6);
		c.add(tf5);
		c.add(l7);
		c.add(tf6);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(l8);
		c.add(l9);
		c.add(tf7);
		c.add(tf8);
		c.add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int id = Integer.parseInt(tf1.getText());
		String name = tf2.getText();
		String aadhar = tf3.getText();
		String phone_no = tf4.getText();
		String license = tf5.getText();
		String address = tf6.getText();
		String cname = tf7.getText();
		
	
		if(e.getSource() == b1)
		{
			try
			{
				
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres","prajwal");
				
				Statement st = con.createStatement();
				st.executeUpdate("insert into customer values('"+id+"','"+name+"','"+aadhar+"','"+phone_no+"','"+license+"','"+address+"')");
				
				JOptionPane.showMessageDialog(this,"data save Successfully : ");
				
				con.close();
				
				

			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(this,"Exception : "+e1);
			}
//			Driver obj = new Driver();
//					obj.setVisible(true);
//                                 obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		if(e.getSource() == b3)
		{
			System.exit(0);
		}
		
		if(e.getSource() ==b2)
		{
//               Driver obj = new Driver();
//					obj.setVisible(true);
//                                 obj.setExtendedState(JFrame.MAXIMIZED_BOTH);    
		}
				if(e.getSource() == b4)
		{
		  try
		  {	
			
				
			  Class.forName("com.mysql.cj.jdbc.Driver");	      
		    	
		    	 Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		      
		    	 java.sql.Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    	
		    
		         
		
		       rs = st.executeQuery("select * from customer where name='"+cname+"'");
		      if(rs.next())
		     {
		       
			   showTableData();
        
		     }else
		           {
		            	
			            JOptionPane.showMessageDialog(this,"record not found");
		            }
		}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(this,"Exception : "+e1);
			}	
		}
	}
	void showTableData()
	{
	DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        
        table = new JTable();
        table.setModel(model);
		
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
		String id1 = "";
		String name1 ="";
		String aadhar1 ="";
		String phone_no1 ="";
		String license1 = "";
		String address1 = "";
        try
		{
			rs.previous();
			while(rs.next())
				{
					id1 = String.valueOf(rs.getInt(1));
					name1 = rs.getString(2);
				    aadhar1 = rs.getString(3);
					 phone_no1 = rs.getString(4);
					 license1 = rs.getString(5);
					 address1 = rs.getString(6);
		
					model.addRow(new Object[]{id1,name1,aadhar1,phone_no1,license1,address1});
				}
		}catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this,"Exception : "+e1);
		}
		
		scroll.setBounds(20,490,600,200);
		c.add(scroll);
}

	public static void main(String args[])
	{
		Customer obj = new Customer();
		obj.setSize(550,600);
		obj.setVisible(true);
		obj.setTitle("Customer Details");
		obj.setLocationRelativeTo(null);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 obj.setVisible(true);
                                 obj.setExtendedState(JFrame.MAXIMIZED_BOTH);

                                    
	}
}