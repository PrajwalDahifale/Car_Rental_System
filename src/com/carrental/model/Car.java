package com.carrental.model;

//CarModel.java
public class Car {
 private int carId;
 private String carModel;
 private String rent;
 private String carNumber;
 private String chassisNumber;
 private String type;
 private String average;

 // Constructor
 public Car(int carId, String carModel, String rent, String carNumber, String chassisNumber, String type, String average) {
     this.carId = carId;
     this.carModel = carModel;
     this.rent = rent;
     this.carNumber = carNumber;
     this.chassisNumber = chassisNumber;
     this.type = type;
     this.average = average;
 }

 // Getters and Setters
 public int getCarId() { return carId; }
 public void setCarId(int carId) { this.carId = carId; }

 public String getCarModel() { return carModel; }
 public void setCarModel(String carModel) { this.carModel = carModel; }

 public String getRent() { return rent; }
 public void setRent(String rent) { this.rent = rent; }

 public String getCarNumber() { return carNumber; }
 public void setCarNumber(String carNumber) { this.carNumber = carNumber; }

 public String getChassisNumber() { return chassisNumber; }
 public void setChassisNumber(String chassisNumber) { this.chassisNumber = chassisNumber; }

 public String getType() { return type; }
 public void setType(String type) { this.type = type; }

 public String getAverage() { return average; }
 public void setAverage(String average) { this.average = average; }
}

