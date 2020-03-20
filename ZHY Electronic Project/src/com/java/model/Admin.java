package com.java.model;

public class Admin {
	private int admin_id;
	private String adminname;
	private String password;
	private String email;
	private String site;
	
	public int getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getAdminname() {
		return adminname;
	}
	
	public void setAdminname(String adminname) {
		this.adminname = adminname;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", adminname=" + adminname + ", password=" + password + "]";
	}
	
}
