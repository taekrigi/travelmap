package com.my.travelmap.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.my.travelmap.param.TravelMapParam;

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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", referencedColumnName = "username")
	private User user;
	
	public void update(TravelMapParam travelMapParam) {
		this.country = travelMapParam.getCountry();
		this.city = travelMapParam.getCity();
		this.latitude = travelMapParam.getLatitude();
		this.longitude = travelMapParam.getLongitude();
	}
}
