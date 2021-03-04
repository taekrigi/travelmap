package com.my.travelmap.repository.travelmap;

import java.util.List;

import com.my.travelmap.dto.VisitedCountryCountDto;

public interface TravelMapRepositoryCustom {
	
	List<VisitedCountryCountDto> getVisitedCountriesCountByUser(String username);

	List<VisitedCountryCountDto> getVisitedCountriesCount();
}
