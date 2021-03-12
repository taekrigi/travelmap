package com.my.travelmap.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.my.travelmap.dto.TravelMapDto;
import com.my.travelmap.dto.VisitedCountryCountDto;
import com.my.travelmap.entity.TravelMap;
import com.my.travelmap.mapper.TravelMapMapper;
import com.my.travelmap.param.TravelMapParam;
import com.my.travelmap.repository.travelmap.TravelMapRepository;
import com.my.travelmap.util.CommonUtilService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelMapService {

	private final TravelMapRepository travelMapRepository;
	private final TravelMapMapper travelMapMapper;
	private final UserService userService;
	
	public List<TravelMapDto> getTravelMapsByUsername(String username) {
		return travelMapMapper.toListDto(travelMapRepository.findAllByUserUsername(username));
	}
	
	public TravelMapDto getTravelMapById(UUID id) {
		return travelMapMapper.toDto(findTravelMapById(id));
	}
	
	@Transactional
	public TravelMapDto addTravelMapByUser(String username, TravelMapParam travelMapParam) {
		TravelMap travelMap = travelMapMapper.toEntity(travelMapParam);
		travelMap.setUser(userService.findUserByUsername(username));
		travelMapRepository.save(travelMap);
		return travelMapMapper.toDto(travelMap);
	}
	
	@Transactional
	public TravelMapDto updateTravelMapById(UUID id, TravelMapParam travelMapParam) {
		TravelMap travelMap = findTravelMapById(id);
		travelMap.update(travelMapParam);
		return travelMapMapper.toDto(travelMap);
	}
	
	@Transactional
	public TravelMapDto deleteTravelMapById(UUID id) {
		TravelMap travelMap = findTravelMapById(id);
		travelMapRepository.deleteById(id);
		return travelMapMapper.toDto(travelMap);
	}
	
	public List<VisitedCountryCountDto> getVisitedCountriesCountByUser(String username) {
		return travelMapRepository.getVisitedCountriesCountByUser(username);
	}
	
	public List<VisitedCountryCountDto> getVisitedCountriesCount() {
		return travelMapRepository.getVisitedCountriesCount();
	}
	
	private TravelMap findTravelMapById(UUID id) {
		return CommonUtilService.throwIfNotExist(travelMapRepository.findById(id), id);	
	}
}
