package com.carrental.view;

//package com.carrental.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class BillPanel extends JFrame implements ActionListener, MouseListener {
    JTextField tfBillDate, tfCarType, tfTotalKm, tfAmount, tfDiscount, tfTotalAmount, tfSearchCarNo, tfCarNo, tfStartingKm, tfRent, tfEndingKm, tfCustomerId, tfBillNo,tfCustomerName;
    JButton btnSave, btnSearchCar, btnExit, btnSearchcustomer;
    JTable table;
   // ResultSet rs;
   // String[] columnNames = {"Car ID", "Car Model", "Rent", "Car No", "Chassis No", "Type", "Average"};
    Container c;
    DefaultTableModel model;
    
    private static final String URL = "jdbc:mysql://localhost:3306/carrentalsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "Prajwal@12";
    static ResultSet rs;
    String[] columnNames = {"id","name","aadhar","phone_no","license","address"};
    
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    BillPanel() {
        c = getContentPane();
        c.setBackground(Color.cyan);
        c.setLayout(null);

        // Labels
        JLabel lblTitle = new JLabel("Bill Details");
        JLabel lblBillDate = new JLabel("Bill Date");
        JLabel lblCarType = new JLabel("Car Type");
        JLabel lblTotalKm = new JLabel("Total Km");
        JLabel lblAmount = new JLabel("Amount");
        JLabel lblDiscount = new JLabel("Discount");
        JLabel lblTotalAmount = new JLabel("Total");
        JLabel lblBillNo = new JLabel("Bill No");
        JLabel lblSearchCarNo = new JLabel("Search Car No");
        JLabel lblCarNo = new JLabel("Car No");
        JLabel lblStartingKm = new JLabel("Starting Km");
        JLabel lblRent = new JLabel("Rent");
        JLabel lblEndingKm = new JLabel("Ending Km");
        JLabel lblCustomerId = new JLabel("Customer ID");
        JLabel lblCustomerName = new JLabel("Customer Name ");

        // Text Fields
        tfBillDate = new JTextField();
        tfCarType = new JTextField();
        tfTotalKm = new JTextField();
        tfAmount = new JTextField();
        tfDiscount = new JTextField();
        tfTotalAmount = new JTextField();
        tfSearchCarNo = new JTextField();
        tfCarNo = new JTextField();
        tfStartingKm = new JTextField();
        tfRent = new JTextField();
        tfEndingKm = new JTextField();
        tfCustomerId = new JTextField();
        tfBillNo = new JTextField();
        tfCustomerName= new JTextField();
        // Buttons
        btnSave = new JButton("Save");
        btnSearchCar = new JButton("Search");
        btnExit = new JButton("Exit");
        btnSearchcustomer = new JButton("Search");

        // Fonts and Bounds
        Font fTitle = new Font("arial", Font.BOLD, 30);
        Font fLabel = new Font("arial", Font.BOLD, 20);
        
        lblTitle.setBounds(620, 20, 400, 50);
        lblTitle.setFont(fTitle);
        
        lblBillDate.setFont(fLabel);
        lblCarType.setFont(fLabel);
        lblTotalKm.setFont(fLabel);
        lblAmount.setFont(fLabel);
        lblDiscount.setFont(fLabel);
        lblTotalAmount.setFont(fLabel);
        lblBillNo.setFont(fLabel);
        lblSearchCarNo.setFont(fLabel);
        lblCarNo.setFont(fLabel);
        lblStartingKm.setFont(fLabel);
        lblRent.setFont(fLabel);
        lblEndingKm.setFont(fLabel);
        lblCustomerId.setFont(fLabel);
        lblCustomerName.setFont(fLabel);
        
        tfBillDate.setFont(fLabel);
        tfCarType.setFont(fLabel);
        tfTotalKm.setFont(fLabel);
        tfAmount.setFont(fLabel);
        tfDiscount.setFont(fLabel);
        tfTotalAmount.setFont(fLabel);
        tfSearchCarNo.setFont(fLabel);
        tfCarNo.setFont(fLabel);
        tfStartingKm.setFont(fLabel);
        tfRent.setFont(fLabel);
        tfEndingKm.setFont(fLabel);
        tfCustomerId.setFont(fLabel);
        tfBillNo.setFont(fLabel);
        tfCustomerName.setFont(fLabel);
        
        btnSave.setFont(fLabel);
        btnSearchCar.setFont(fLabel);
        btnExit.setFont(fLabel);
        btnSearchcustomer.setFont(fLabel);

        // Set bounds for Labels and TextFields
        lblBillDate.setBounds(1000, 20, 150, 30);
        lblCarType.setBounds(1000, 260, 150, 30);
        lblTotalKm.setBounds(1000, 340, 150, 30);
        lblAmount.setBounds(1000, 420, 150, 30);
        lblDiscount.setBounds(1000, 500, 150, 30);
        lblTotalAmount.setBounds(1000, 580, 150, 30);
        lblBillNo.setBounds(20, 20, 150, 30);
        lblSearchCarNo.setBounds(20, 450, 800, 30);
        lblCarNo.setBounds(20, 260, 150, 30);
        lblStartingKm.setBounds(20, 340, 150, 30);
        lblRent.setBounds(500, 260, 150, 30);
        lblEndingKm.setBounds(500, 340, 150, 30);
        lblCustomerId.setBounds(20, 180, 150, 30);
        lblCustomerName.setBounds(600, 180, 250, 30);
        
        tfBillDate.setBounds(1100, 20, 250, 30);
        tfCarType.setBounds(1100, 260, 250, 30);
        tfTotalKm.setBounds(1100, 340, 250, 30);
        tfAmount.setBounds(1100, 420, 250, 30);
        tfDiscount.setBounds(1100, 500, 250, 30);
        tfTotalAmount.setBounds(1100, 580, 250, 30);
        tfSearchCarNo.setBounds(180, 450, 300, 30);
        tfBillNo.setBounds(100, 20, 250, 30);
        tfCarNo.setBounds(150, 260, 250, 30);
        tfStartingKm.setBounds(150, 340, 250, 30);
        tfRent.setBounds(650, 260, 250, 30);
        tfEndingKm.setBounds(650, 340, 250, 30);
        tfCustomerId.setBounds(150, 180, 250, 30);
        tfCustomerName.setBounds(780, 180, 250, 30);

        btnSave.setBounds(770, 640, 125, 30);
        btnSearchCar.setBounds(500, 450, 125, 30);
        btnExit.setBounds(1100, 640, 125, 30);
        btnSearchcustomer.setBounds(420, 180, 125, 30);

        // Adding components to the container
        c.add(lblTitle);
        c.add(lblBillDate);
        c.add(tfBillDate);
        c.add(lblCarType);
        c.add(tfCarType);
        c.add(lblTotalKm);
        c.add(tfTotalKm);
        c.add(lblAmount);
        c.add(tfAmount);
        c.add(lblDiscount);
        c.add(tfDiscount);
        c.add(lblTotalAmount);
        c.add(tfTotalAmount);
        c.add(btnSave);
        c.add(btnSearchCar);
        c.add(btnExit);
        c.add(lblBillNo);
        c.add(lblSearchCarNo);
        c.add(tfSearchCarNo);
        c.add(btnSearchcustomer);
        c.add(lblCarNo);
        c.add(lblStartingKm);
        c.add(lblRent);
        c.add(lblEndingKm);
        c.add(lblCustomerId);
        c.add(tfCarNo);
        c.add(tfStartingKm);
        c.add(tfRent);
        c.add(tfEndingKm);
        c.add(tfCustomerId);
        c.add(tfBillNo);
        c.add(lblCustomerName);
        c.add(tfCustomerName);

        // Action listeners
        btnSave.addActionListener(this);
        btnSearchCar.addActionListener(this);
        btnExit.addActionListener(this);
        btnSearchcustomer.addActionListener(this);

        // Mouse listener for table row click
        table = new JTable();
        table.addMouseListener(this);

        // Adding table scroll pane
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20, 500, 600, 200);
        c.add(scroll);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        }

        if (e.getSource() == btnSearchCar) {
            String carNo = tfSearchCarNo.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem", "root", "Prajwal@12");

                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = st.executeQuery("SELECT * FROM car WHERE carNumber='" + carNo + "'");
                if (rs.next()) {
                    showTableData();
                } else {
                    JOptionPane.showMessageDialog(this, "Record not found");
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "Exception: " + e1);
            }
        }
        
        if(e.getSource() == btnSearchcustomer) {
        	
        	String Id = tfCustomerId.getText();
        	 String query = "SELECT * FROM customer WHERE id = ?";
        	    try (Connection con = connect();
        	         PreparedStatement pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

        	        pstmt.setString(1, Id);
        	        ResultSet rs = pstmt.executeQuery();
        	        if(rs.next()) {
                       rs.previous();
        	        while (rs.next()) {
        	            int id = rs.getInt("id");
        	            tfCustomerName.setText(rs.getString("name"));
        	        }
        	        }else {
        	        	JOptionPane.showMessageDialog(null,"enter the valid id");
        	        }
        	    }catch(Exception e1)
    			{
    				JOptionPane.showMessageDialog(null,"Exception : "+e1);
    				
    			}
        }
        
        //if(e.getSource() == btnSave) {
//            try {
//                // Load MySQL JDBC Driver
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//                // Establish connection to MySQL database
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem", "root", "Prajwal@12");
//
//                // Create statement
//                Statement st = con.createStatement();
//
//                // Execute the INSERT query to add the car details
//                st.executeUpdate("INSERT INTO car (car_id, car_model, rent, car_no, chassics_no, type, avrage) VALUES ('" 
//                                 + car_id + "','" + car_model + "','" + rent + "','" + car_no + "','" + chassics_no + "','" + type + "','" + avrage + "')");
//
//                // Show success message
//                JOptionPane.showMessageDialog(this, "Data saved successfully!");
//
//                // Close the connection
//                con.close();
//
//            } catch(Exception e1) {
//                // Handle exceptions
//                JOptionPane.showMessageDialog(this, "Exception: " + e1);
//            }
//        }

    }

    void showTableData() {
        model.setRowCount(0); // Clear existing data

        try {
            rs.beforeFirst(); // Move cursor before first row
            while (rs.next()) {
            	 int id = rs.getInt("carId");
                 String carModel = rs.getString("carModel");
                 String rent = rs.getString("rent");
                 String carNo = rs.getString("carNumber");
                 String chassisNumber = rs.getString("chassisNumber");
                 String type = rs.getString("type");
                 String average = rs.getString("average");
                

                model.addRow(new Object[]{id, carModel, rent, carNo, chassisNumber, type, average});
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, "Exception: " + e1);
        }
    }

    // Mouse click event to populate fields from table row
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        tfCarNo.setText(model.getValueAt(row, 3).toString());
        tfRent.setText(model.getValueAt(row, 2).toString());
        tfCarType.setText(model.getValueAt(row, 5).toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String args[]) {
        BillPanel obj = new BillPanel();
        obj.setSize(550, 600);
        obj.setVisible(true);
        obj.setTitle("Bill Details");
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}

