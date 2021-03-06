package com.my.travelmap.dto;

import java.time.LocalDateTime;
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
	
	private LocalDateTime visitedDate;
}
