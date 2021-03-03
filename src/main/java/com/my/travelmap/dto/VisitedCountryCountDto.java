package com.my.travelmap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class VisitedCountryCountDto {
	
	private String country;
		
	private Long count;

}
