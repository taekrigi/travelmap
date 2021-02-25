package com.my.travelmap.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class User extends BaseEntity {

	private String username;
	
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<TravelMap> travelMaps;
}
