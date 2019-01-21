package com.apeamcet.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


public class UserModel {
	
	int id;
	@Range(min=5,max=20)
	String username;
	@NotEmpty
	String password;
	@NotEmpty
	String confirmPassword;
	@Email
	String email;
	@NotEmpty
	String contact;
	
	int role;
	String rolename;
	
	public UserModel() {
		super();
	}

	public UserModel(int id, String username, String password, String email,
			String contact, int role, String rolename, String confirmPassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.role = role;
		this.rolename=rolename;
		this.confirmPassword=confirmPassword;
	}
	/*
	 * Getters and Setters.
	 */
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
