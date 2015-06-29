package com.angular.dto;

import java.io.Serializable;

public class CustomUserDTO implements Serializable{
	

	private static final long serialVersionUID = -3126526607577475249L;


	private String id;

	
	private String name;
	
		
	private String code;
	
	
	private String surname;
	
	
	private String email;	
	
	
	private String userName ;
	
		
	private String systemRole;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getSystemRole() {
		return systemRole;
	}


	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}

}
