package com.entity;

public class User {
	 private int id;
	 private String fname;
	 private String email;
	 private String password;
	 
	 
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String fname, String email, String password) {
		
		this.fname = fname;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 

}
