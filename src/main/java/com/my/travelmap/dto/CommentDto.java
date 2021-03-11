package com.my.travelmap.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentDto {

	private UUID id;

	private String writer;
	
	private String content;
	
	private LocalDateTime creaetedAt;
	
	private LocalDateTime updatedAt;
}
