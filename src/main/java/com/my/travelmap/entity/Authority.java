package com.my.travelmap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Authority implements Serializable {

	private static final long serialVersionUID = 5617244041075467778L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
	User user;
	
	@Column
	String authority;
}