package com.dto;

public class User {
	private String firstName;
	private String lastName;
	private String userName;
	private String mailId;
	private String password;
	
	public User() {
		super();
		
	}
	
	public User(String firstName, String lastName, String userName, String mailId, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.mailId = mailId;
		this.password = password;
	}

	/*public User(String userName, String query, String category) {
		super();
		this.userName = userName;
		this.query = query;
		this.category = category;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", mailId="
				+ mailId + ", password=" + password + "]";
	}

	
	
	
}
