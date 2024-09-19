package com.carrental.view;
import com.carrental.model.Driver;
import com.carrental.model.Driver.*;
import com.carrental.Database.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DriverPanel extends JFrame implements ActionListener {
    JTextField driverIdField, driverNameField, driverAadharField, driverPhoneField, driverLicenseField, driverAddressField, searchNameField,driverTableFeild;
    JButton saveButton, nextButton, exitButton, searchButton;
    JTable resultTable;
    Container container;
    DriverData driverData = new DriverData(); // Object for database operations
Driver D = new Driver(1, null, null, null, null,null);
    public DriverPanel() {
        container = getContentPane();
        container.setBackground(Color.cyan);
        container.setLayout(null);

        // Labels and Text Fields
        ImageIcon icon = new ImageIcon("C:\\Users\\My PC\\Desktop\\CarRentalSystem\\CarRentalSystem\\resources\\Driver2.png");
        JLabel titleLabel = new JLabel("DRIVER DETAILS");
        JLabel driverIdLabel = new JLabel("DRIVER ID");
        JLabel driverNameLabel = new JLabel("DRIVER NAME");
        JLabel driverAadharLabel = new JLabel("DRIVER AADHAR_NO");
        JLabel driverPhoneLabel = new JLabel("DRIVER PHONENO");
        JLabel driverLicenseLabel = new JLabel("DRIVER LICENSE_NO");
        JLabel driverAddressLabel = new JLabel("DRIVER ADDRESS");
        JLabel searchNameLabel = new JLabel("Search Driver Name ");
        JLabel imagel = new JLabel(icon);
        driverIdField = new JTextField();
        driverNameField = new JTextField();
        driverAadharField = new JTextField();
        driverPhoneField = new JTextField();
        driverLicenseField = new JTextField();
        driverAddressField = new JTextField();
        searchNameField = new JTextField();
        driverTableFeild = new JTextField();
        
        saveButton = new JButton("SAVE");
        nextButton = new JButton("NEXT");
        exitButton = new JButton("EXIT");
        searchButton = new JButton("SEARCH");

        // Font Settings
        Font titleFont = new Font("Arial", Font.BOLD, 40);
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        titleLabel.setFont(titleFont);
        driverIdLabel.setFont(labelFont);
        driverNameLabel.setFont(labelFont);
        driverAadharLabel.setFont(labelFont);
        driverPhoneLabel.setFont(labelFont);
        driverLicenseLabel.setFont(labelFont);
        driverAddressLabel.setFont(labelFont);
        searchNameLabel.setFont(labelFont);
        
        driverIdField.setFont(labelFont);
        driverNameField.setFont(labelFont);
        driverAadharField.setFont(labelFont);
        driverPhoneField.setFont(labelFont);
        driverLicenseField.setFont(labelFont);
        driverAddressField.setFont(labelFont);
        searchNameField.setFont(labelFont);
        
        saveButton.setFont(labelFont);
        nextButton.setFont(labelFont);
        exitButton.setFont(labelFont);
        searchButton.setFont(labelFont);

        // Positioning Components
        titleLabel.setBounds(500, 20, 400, 50);
        driverIdLabel.setBounds(700, 100, 250, 30);
        driverNameLabel.setBounds(700, 180, 250, 30);
        driverAadharLabel.setBounds(700, 260, 250, 30);
        driverPhoneLabel.setBounds(700, 340, 250, 30);
        driverLicenseLabel.setBounds(700, 420, 250, 30);
        driverAddressLabel.setBounds(700, 500, 250, 30);
        searchNameLabel.setBounds(20, 400, 800, 30);
        imagel.setBounds(0,0,500,400);
        
        driverIdField.setBounds(1000, 100, 300, 30);
        driverNameField.setBounds(1000, 180, 300, 30);
        driverAadharField.setBounds(1000, 260, 300, 30);
        driverPhoneField.setBounds(1000, 340, 300, 30);
        driverLicenseField.setBounds(1000, 420, 300, 30);
        driverAddressField.setBounds(1000, 500, 300, 60);
        searchNameField.setBounds(220, 400, 300, 30);
        driverTableFeild.setBounds(20,450,600,230);
        
        saveButton.setBounds(770, 600, 125, 30);
        nextButton.setBounds(1000, 600, 125, 30);
        exitButton.setBounds(1200, 600, 125, 30);
        searchButton.setBounds(550, 400, 125, 30);
        
        // Adding Components to the Container
        container.add(titleLabel);
        container.add(driverIdLabel);
        container.add(driverIdField);
        container.add(driverNameLabel);
        container.add(driverNameField);
        container.add(driverAadharLabel);
        container.add(driverAadharField);
        container.add(driverPhoneLabel);
        container.add(driverPhoneField);
        container.add(driverLicenseLabel);
        container.add(driverLicenseField);
        container.add(driverAddressLabel);
        container.add(driverAddressField);
        container.add(searchNameLabel);
        container.add(searchNameField);
        container.add(saveButton);
        container.add(nextButton);
        container.add(exitButton);
        container.add(searchButton);
        container.add(imagel);
        container.add(driverTableFeild);
        // Adding Action Listeners
        saveButton.addActionListener(this);
        nextButton.addActionListener(this);
        exitButton.addActionListener(this);
        searchButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            Driver driver = new Driver(
                Integer.parseInt(driverIdField.getText()),
                driverNameField.getText(),
                driverAadharField.getText(),
                driverPhoneField.getText(),
                driverLicenseField.getText(),
                driverAddressField.getText()
            );
            driverData.saveDriver(driver);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == nextButton) {
        	AdminPanel obj = new AdminPanel();
            obj.setSize(550, 600);
            obj.setVisible(true);
            obj.setTitle("Admin Panel");
            obj.setLocationRelativeTo(null);
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        } else if (e.getSource() == searchButton) {
            String name = searchNameField.getText();
            List<Driver> rs = driverData.getDriversByName(name);
            showTableData(rs);
        }
    }

    void showTableData(List<Driver> drivers) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            String[] columnNames = {"ID", "Name", "Aadhar", "Phone No", "License", "Address"};
            model.setColumnIdentifiers(columnNames);
            resultTable = new JTable();
            resultTable.setModel(model);
            resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            resultTable.setFillsViewportHeight(true);
            JScrollPane scroll = new JScrollPane(resultTable);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            for (Driver driver : drivers) {
                model.addRow(new Object[]{driver.getId(), driver.getName(), driver.getAadhar(), driver.getPhoneNo(), driver.getLicense(), driver.getAddress()});
            }

            scroll.setBounds(20, 450, 600, 200);
            container.add(scroll);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, "Exception: " + e1);
        }
    }


//    public static void main(String[] args) {
//        DriverPanel obj = new DriverPanel();
//        obj.setSize(550, 600);
//        obj.setVisible(true);
//        obj.setTitle("Driver Details");
//        obj.setLocationRelativeTo(null);
//        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
//    }
}


