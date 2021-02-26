package com.my.travelmap.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.my.travelmap.dto.TravelMapDto;
import com.my.travelmap.entity.TravelMap;
import com.my.travelmap.mapper.TravelMapMapper;
import com.my.travelmap.repository.TravelMapRepository;
import com.my.travelmap.util.CommonUtilService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelMapService {

	private final TravelMapRepository travelMapRepository;
	private final TravelMapMapper travelMapMapper;
	
	public List<TravelMapDto> getTravelMapsByUsername(String username) {
		return travelMapMapper.toListDto(travelMapRepository.findAllByUser(username));
	}
	
	public TravelMapDto getTravelMapById(UUID id) {
		return travelMapMapper.toDto(findTravelMapById(id));
	}
	
	private TravelMap findTravelMapById(UUID id) {
		return CommonUtilService.throwIfNotExist(travelMapRepository.findById(id), id);	
	}
}
