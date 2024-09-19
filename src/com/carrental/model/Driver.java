package com.carrental.model;

public class Driver {
    private int id;
    private String name;
    private String aadhar;
    private String phoneNo;
    private String license;
    private String address;

    public Driver(int id, String name, String aadhar, String phoneNo, String license, String address) {
        this.id = id;
        this.name = name;
        this.aadhar = aadhar;
        this.phoneNo = phoneNo;
        this.license = license;
        this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAadhar() { return aadhar; }
    public String getPhoneNo() { return phoneNo; }
    public String getLicense() { return license; }
    public String getAddress() { return address; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAadhar(String aadhar) { this.aadhar = aadhar; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public void setLicense(String license) { this.license = license; }
    public void setAddress(String address) { this.address = address; }
}

