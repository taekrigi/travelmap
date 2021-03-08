package com.my.travelmap.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TravelMapDto {

	private UUID id;

	private String country;
	
	private String city;
	
	private String latitude;
	
	private String longitude;
}
