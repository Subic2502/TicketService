package com.example.demo.dto;

public class UpdateRequest {
	private String usernameOrEmail;
	private String password;
	private String fullName;
	
	private String newPassword;
	private String newEmail;
	private String newUsername;
	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}
	public void setUsername(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewEmail() {
		return newEmail;
	}
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}
	public String getNewUsername() {
		return newUsername;
	}
	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}
	public UpdateRequest(String usernameOrEmail, String password, String fullName, String newPassword,
			String newEmail, String newUsername) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
		this.fullName = fullName;
		this.newPassword = newPassword;
		this.newEmail = newEmail;
		this.newUsername = newUsername;
	}
	public UpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
