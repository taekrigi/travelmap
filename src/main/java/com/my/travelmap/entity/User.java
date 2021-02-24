package com.my.travelmap.entity;

import java.util.UUID;

import javax.persistence.Table;

@Table
public class User {
	
	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	
}
