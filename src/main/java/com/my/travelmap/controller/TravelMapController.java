package com.my.travelmap.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.travelmap.dto.TravelMapDto;
import com.my.travelmap.param.TravelMapParam;
import com.my.travelmap.service.TravelMapService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("travelmap")
@RequiredArgsConstructor
public class TravelMapController {

	private final TravelMapService travelMapService;
	
	@GetMapping("/user/{username}")
	public List<TravelMapDto> getTravelMapsByUsername(@PathVariable("username") String username) {
		return travelMapService.getTravelMapsByUsername(username);
	}
	
	@GetMapping("{id}")
	public TravelMapDto getTravelMapById(@PathVariable("id") UUID id) {
		return travelMapService.getTravelMapById(id);
	}
	
	@PostMapping("/user/{username}")
	public ResponseEntity<TravelMapDto> addTravelMapByUser(
			@PathVariable("username") String username, 
			@Valid @RequestBody TravelMapParam travelMapParam
	) throws URISyntaxException {
		TravelMapDto travelMapDto = travelMapService.addTravelMapByUser(username, travelMapParam);
		return ResponseEntity.created(new URI("/travelmap/" + travelMapDto.getId())).body(travelMapDto);
	}
	
	@PutMapping("{id}")
	public TravelMapDto updateTravelMapById(UUID id, @Valid @RequestBody TravelMapParam travelMapParam) {
		return travelMapService.updateTravelMapById(id, travelMapParam);
	}
	
	@DeleteMapping("{id}")
	public TravelMapDto deleteTravelMapById(UUID id) {
		return travelMapService.deleteTravelMapById(id);
	}
	
	@GetMapping("/count/countries/{username}")
	public List<Map<String, Object>> getVisitedCountriesCountByUser(@PathVariable("username") String username) {
		return travelMapService.getVisitedCountriesCountByUser(username);
	}
	
}
