package com.my.travelmap.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserDto {

	private UUID id;

	private String username;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	private String role;
	
	private List<TravelMapDto> travelMaps;
}
