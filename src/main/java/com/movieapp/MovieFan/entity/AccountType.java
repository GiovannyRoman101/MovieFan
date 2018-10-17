package com.movieapp.MovieFan.entity;

public enum AccountType {
	USER("User"), ADMIN("Admin");
	
	private String type;
	
	private AccountType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
