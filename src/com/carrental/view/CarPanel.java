package com.carrental.view;

//CarDetails.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.carrental.Database.CarData;
import com.carrental.model.Car;
import com.carrental.model.Driver;

public class CarPanel extends JFrame implements ActionListener {
 JTextField carIdField, carModelField, rentField, carNumberField, chassisNumberField, typeField, averageField, searchField;
 JButton saveButton, nextButton, exitButton, searchButton;
 Container container;
 JTable carTable;
 CarData carDatabase;
 String[] columnNames = {"Car ID", "Car Model", "Rent", "Car Number", "Chassis Number", "Type", "Average"};

 public CarPanel() {
     carDatabase = new CarData();
     
     container = getContentPane();
     container.setBackground(Color.cyan);
     container.setLayout(null);

     ImageIcon icon = new ImageIcon("C:/Users/My PC/Desktop/project/Resources/kia1.png");
     JLabel titleLabel = new JLabel("Car Details");
     JLabel carIdLabel = new JLabel("Car ID");
     JLabel carModelLabel = new JLabel("Car Model");
     JLabel rentLabel = new JLabel("Rent");
     JLabel carNumberLabel = new JLabel("Car Number");
     JLabel chassisNumberLabel = new JLabel("Chassis Number");
     JLabel typeLabel = new JLabel("Type");
     JLabel carImageLabel = new JLabel(icon);
     JLabel searchLabel = new JLabel("Search by Car Number");
     JLabel averageLabel = new JLabel("Average");

     carIdField = new JTextField();
     carModelField = new JTextField();
     rentField = new JTextField();
     carNumberField = new JTextField();
     chassisNumberField = new JTextField();
     typeField = new JTextField();
     searchField = new JTextField();
     averageField = new JTextField();

     saveButton = new JButton("Save");
     nextButton = new JButton("Next");
     exitButton = new JButton("Exit");
     searchButton = new JButton("Search");

     Font titleFont = new Font("Arial", Font.BOLD, 30);
     Font labelFont = new Font("Arial", Font.BOLD, 20);
     
     titleLabel.setBounds(600, 20, 400, 50);
     titleLabel.setFont(titleFont);
     carIdLabel.setFont(labelFont);
     carModelLabel.setFont(labelFont);
     rentLabel.setFont(labelFont);
     carNumberLabel.setFont(labelFont);
     chassisNumberLabel.setFont(labelFont);
     typeLabel.setFont(labelFont);
     searchLabel.setFont(labelFont);
     averageLabel.setFont(labelFont);

     carIdField.setFont(labelFont);
     carModelField.setFont(labelFont);
     rentField.setFont(labelFont);
     carNumberField.setFont(labelFont);
     chassisNumberField.setFont(labelFont);
     typeField.setFont(labelFont);
     searchField.setFont(labelFont);
     averageField.setFont(labelFont);

     saveButton.setFont(labelFont);
     nextButton.setFont(labelFont);
     exitButton.setFont(labelFont);
     searchButton.setFont(labelFont);

     carIdLabel.setBounds(770, 100, 250, 30);
     carModelLabel.setBounds(770, 180, 250, 30);
     rentLabel.setBounds(770, 260, 250, 30);
     carNumberLabel.setBounds(770, 340, 250, 30);
     chassisNumberLabel.setBounds(770, 420, 250, 30);
     typeLabel.setBounds(770, 500, 250, 30);
     carImageLabel.setBounds(0, 0, 700, 390);
     searchLabel.setBounds(20, 400, 800, 30);
     averageLabel.setBounds(770, 580, 250, 30);

     carIdField.setBounds(1000, 100, 300, 30);
     carModelField.setBounds(1000, 180, 300, 30);
     rentField.setBounds(1000, 260, 300, 30);
     carNumberField.setBounds(1000, 340, 300, 30);
     chassisNumberField.setBounds(1000, 420, 300, 30);
     typeField.setBounds(1000, 500, 300, 30);
     searchField.setBounds(250, 400, 300, 30);
     averageField.setBounds(1000, 580, 300, 30);

     saveButton.setBounds(770, 650, 125, 30);
     nextButton.setBounds(1000, 650, 125, 30);
     exitButton.setBounds(1200, 650, 125, 30);
     searchButton.setBounds(550, 400, 125, 30);

     container.add(titleLabel);
     container.add(carIdLabel);
     container.add(carIdField);
     container.add(carModelLabel);
     container.add(carModelField);
     container.add(rentLabel);
     container.add(rentField);
     container.add(carNumberLabel);
     container.add(carNumberField);
     container.add(chassisNumberLabel);
     container.add(chassisNumberField);
     container.add(typeLabel);
     container.add(typeField);
     container.add(saveButton);
     container.add(nextButton);
     container.add(exitButton);
     container.add(carImageLabel);
     container.add(searchLabel);
     container.add(searchField);
     container.add(averageLabel);
     container.add(averageField);
     container.add(searchButton);

     saveButton.addActionListener(this);
     nextButton.addActionListener(this);
     exitButton.addActionListener(this);
     searchButton.addActionListener(this);
 }

 public void actionPerformed(ActionEvent e) {
     int carId = Integer.parseInt(carIdField.getText());
     String carModel = carModelField.getText();
     String rent = rentField.getText();
     String carNumber = carNumberField.getText();
     String chassisNumber = chassisNumberField.getText();
     String type = typeField.getText();
     String average = averageField.getText();
     String searchCarNumber = searchField.getText();

     if (e.getSource() == saveButton) {
         try {
             Car car = new Car(carId, carModel, rent, carNumber, chassisNumber, type, average);
             carDatabase.saveCar(car);
             JOptionPane.showMessageDialog(this, "Data saved successfully");
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "Exception: " + ex.getMessage());
         }
     }

     if (e.getSource() == exitButton) {
         System.exit(0);
     }

     if (e.getSource() == nextButton) {
    	 AdminPanel obj = new AdminPanel();
         obj.setSize(550, 600);
         obj.setVisible(true);
         obj.setTitle("Admin Panel");
         obj.setLocationRelativeTo(null);
         obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         obj.setExtendedState(JFrame.MAXIMIZED_BOTH); 
         dispose();
     }

     if (e.getSource() == searchButton) {
    	 CarData  carData = new CarData(); 
    	 String carNo = searchField.getText();
         List<Car> rs;
		
				rs = carData.getCarsByNO(carNo);
				showTableData(rs);
			
			
		
        // showTableData(rs);
     }
 }

 void showTableData(List<Car>Cars) {
     try {
         DefaultTableModel model = new DefaultTableModel();
         String[] columnNames = {"id", "carModel", "rent", "carNo","chassisNumber", "type",  "average"};
         model.setColumnIdentifiers(columnNames);
         JTable resultTable = new JTable();
         resultTable.setModel(model);
         resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
         resultTable.setFillsViewportHeight(true);
         JScrollPane scroll = new JScrollPane(resultTable);
         scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

         for (Car car : Cars) {
             model.addRow(new Object[]{car.getCarId(), car.getCarModel(), car.getRent(), car.getCarNumber(), car.getChassisNumber(), car.getType(),car.getAverage()});
        
         }

         scroll.setBounds(20, 450, 600, 200);
         container.add(scroll);
     } catch (Exception e1) {
         JOptionPane.showMessageDialog(this, "Exception: " + e1);
     }
 }
 public static void main(String[] args) {
     CarPanel carDetailsPage = new CarPanel();
     carDetailsPage.setSize(1600, 800); // Increased size for better view
     carDetailsPage.setVisible(true);
     carDetailsPage.setTitle("Car Details");
     carDetailsPage.setLocationRelativeTo(null);
     carDetailsPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}
