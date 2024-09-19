package com.carrental.model;

//import javax.swing.JTextField;

public class Customer {
	
	private int Id;
	private String NameTF,PhoneTF,AddTF,AdharNOTF,SearchNameTF,LINCENSENOTF;
	
	
	 public Customer(int id, String name, String aadhar, String phoneNo, String license, String address) {
	        this.Id = id;
	        this.NameTF = name;
	        this.AdharNOTF = aadhar;
	        this.PhoneTF = phoneNo;
	        this.LINCENSENOTF = license;
	        this.AddTF = address;
	    }
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNameTF() {
		return NameTF;
	}
	public void setNameTF(String nameTF) {
		NameTF = nameTF;
	}
	public String getPhoneTF() {
		return PhoneTF;
	}
	public void setPhoneTF(String phoneTF) {
		PhoneTF = phoneTF;
	}
	
	public String getAddTF() {
		return AddTF;
	}
	public void setAddTF(String addTF) {
		AddTF = addTF;
	}
	public String getAdharNOTF() {
		return AdharNOTF;
	}
	public void setAdharNOTF(String adharNOTF) {
		AdharNOTF = adharNOTF;
	}
	public String getSearchNameTF() {
		return SearchNameTF;
	}
	public void setSearchNameTF(String searchNameTF) {
		SearchNameTF = searchNameTF;
	}
	public String getLINCENSENOTF() {
		return LINCENSENOTF;
	}
	public void setLINCENSENOTF(String lINCENSENOTF) {
		LINCENSENOTF = lINCENSENOTF;
	}
	
	
}
