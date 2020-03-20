package com.java.model;

public class User {
	private Integer id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String site;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public User( String name,  String email, String phone, String site) {
        this.name = name;
        this.email=email;
        this.phone=phone;
        this.site=site;
	}
	
	public User(Integer id, String name, String email, String phone, String site) {
		this.id=id;
        this.name = name;
        this.email=email;
        this.phone=phone;
        this.site=site;
	}
	
	public User() {
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", site=" + site + "]";
	}
	
}