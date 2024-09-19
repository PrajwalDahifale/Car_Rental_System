//package com.carrental.model;
//import com.carrental.view.*;
//import com.carrental.Database.*;
//
////package com.carrental.controller;
////
////import com.carrental.model.CarRentalModel;
////import com.carrental.view.BillView;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//
//import java.awt.event.*;
//import java.sql.*;
//
//public class Bill {
//    private BillData model;
//    private BillPanel view;
//
//    public Bill(BillData model, BillPanel view) {
//        this.model = model;
//        this.view = view;
//
//        view.btnSearch.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                searchCar();
//            }
//        });
//
//        view.btnSave.addActionListener(e -> saveBill());
//
//        view.btnExit.addActionListener(e -> System.exit(0));
//    }
//
//    private void searchCar() {
//        String carNo = view.tfCarNo.getText();
//        ResultSet rs = model.searchCarByNumber(carNo);
//
//        try {
//            if (rs.next()) {
//                // Populate JTable with search results
//                String[] columnNames = {"Car ID", "Car Model", "Rent", "Car No", "Chassis No", "Type", "Average"};
//                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
//
//                do {
//                    String carId = rs.getString("car_id");
//                    String carModel = rs.getString("car_model");
//                    String rent = rs.getString("rent");
//                    String carNumber = rs.getString("car_no");
//                    String chassisNo = rs.getString("chassis_no");
//                    String type = rs.getString("type");
//                    String avg = rs.getString("avrage");
//
//                    tableModel.addRow(new Object[]{carId, carModel, rent, carNumber, chassisNo, type, avg});
//                } while (rs.next());
//
//                view.table.setModel(tableModel);
//                view.lblStatus.setText("Car found.");
//            } else {
//                view.lblStatus.setText("No car found with that number.");
//            }
//        } catch (SQLException e) {
//            view.lblStatus.setText("Error: " + e.getMessage());
//        }
//    }
//
//    private void saveBill() {
//        String billNo = view.tfBillNo.getText();
//        String billDate = view.tfBillDate.getText();
//        String type = view.tfType.getText();
//        int totalKm = Integer.parseInt(view.tfTotalKm.getText());
//        double amount = Double.parseDouble(view.tfAmount.getText());
//        double discount = Double.parseDouble(view.tfDiscount.getText());
//        double total = Double.parseDouble(view.tfTotal.getText());
//        String carNo = view.tfCarNo.getText();
//        int customerId = Integer.parseInt(view.tfCustomerId.getText());
//
//        model.saveBill(billNo, billDate, type, totalKm, amount, discount, total, carNo, customerId);
//        view.lblStatus.setText("Bill saved successfully.");
//    }
//}
//
