package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	private String uName;
	private String uPassword;
	private String uRole;
	
	public UserInfo() {
		super();
	}

	public UserInfo(int uId, String uName, String uPassword, String uRole) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uRole = uRole;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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

	public String getuRole() {
		return uRole;
	}

	public void setuRole(String uRole) {
		this.uRole = uRole;
	}

	@Override
	public String toString() {
		return "UserInfo [uId=" + uId + ", uName=" + uName + ", uPassword=" + uPassword + ", uRole=" + uRole + "]";
	}
	

}
