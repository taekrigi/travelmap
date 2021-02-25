package com.my.travelmap.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class TravelMap extends BaseEntity {
	
	private String country;
	
	private String city;
	
	private String latitude;
	
	private String longitude;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
