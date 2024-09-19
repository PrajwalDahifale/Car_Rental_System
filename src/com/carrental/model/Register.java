package com.carrental.model;

public class Register {
	private static final int IdTF = 0;
	private int Id;
	private String NameTF,PassTF,PhoneTF,EmailTF,AddTF;
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
	public String getPassTF() {
		return PassTF;
	}
	public void setPassTF(String passTF) {
		PassTF = passTF;
	}
	public String getPhoneTF() {
		return PhoneTF;
	}
	public void setPhoneTF(String phoneTF) {
		PhoneTF = phoneTF;
	}
	public String getEmailTF() {
		return EmailTF;
	}
	public void setEmailTF(String emailTF) {
		EmailTF = emailTF;
	}
	public String getAddTF() {
		return AddTF;
	}
	public void setAddTF(String addTF) {
		AddTF = addTF;
	}

}
