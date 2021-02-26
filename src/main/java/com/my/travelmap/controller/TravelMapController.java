package com.my.travelmap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.travelmap.dto.TravelMapDto;
import com.my.travelmap.service.TravelMapService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("travelmap")
@RequiredArgsConstructor
public class TravelMapController {

	private final TravelMapService travelMapService;
	
	@GetMapping("{username}")
	public List<TravelMapDto> getTravelMapsByUsername(@PathVariable("username") String username) {
		return null;
	}
	
}
