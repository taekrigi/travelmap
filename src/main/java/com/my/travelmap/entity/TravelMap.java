package com.my.travelmap.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.my.travelmap.entity.base.BaseEntity;
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

	private LocalDateTime visitedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", referencedColumnName = "username")
	private User user;
	
	public void update(TravelMapParam travelMapParam) {
		this.country = travelMapParam.getCountry();
		this.visitedDate = travelMapParam.getVisitedDate();
	}
}
