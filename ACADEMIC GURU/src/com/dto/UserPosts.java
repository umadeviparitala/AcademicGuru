package com.dto;

public class UserPosts {
	
	private String userName;
	private String query;
	private String category;
	
	
	
	public UserPosts() {
		super();
	}


	public UserPosts(String userName, String query, String category) {
		super();
		this.userName = userName;
		this.query = query;
		this.category = category;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getQuery() {
		return query;
	}


	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	

	@Override
	public String toString() {
		return "UserPosts [userName=" + userName + ", query=" + query + ", category=" + category + "]";
	}


	

	

		
}
