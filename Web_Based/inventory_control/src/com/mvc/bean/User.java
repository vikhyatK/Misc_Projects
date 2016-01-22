package com.mvc.bean;

public class User {
	String name;
    String userid;
    String password;
    int phone;
    String role;
    
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public User() {	}
		
	public User(String name, String userid, String password, int phone) {
		super();
		this.name = name;
		this.userid = userid;
		this.password = password;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", userid=" + userid + ", password="
				+ password + ", phone=" + phone + "]";
	}
	
    
}
