package com.my.travelmap.security;

import java.util.Arrays;

public enum UserRole {
	
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER")
	
	;
	
	private String role;
	
	UserRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public static UserRole of(String role) {
		return Arrays.stream(UserRole.values())	
				.filter(e -> e.name().equals(role.toUpperCase()))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(role + " is not UserRole"));
	}

}
