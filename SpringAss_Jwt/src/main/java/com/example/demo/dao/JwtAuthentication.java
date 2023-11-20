package com.example.demo.dao;

public class JwtAuthentication {
	
	private String uName;
	private String uPassword;
	
	public JwtAuthentication() {
		super();
	}
	
	public JwtAuthentication(String uName, String uPassword) {
		super();
		this.uName = uName;
		this.uPassword = uPassword;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	@Override
	public String toString() {
		return "JwtAuthentication [uName=" + uName + ", uPassword=" + uPassword + "]";
	}

}
