package com.my.travelmap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class VisitedCountryCountDto {
	
	private String country;
		
	private int count;
	

}
