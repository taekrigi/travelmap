package com.my.travelmap.repository.travelmap;

import java.util.List;
import java.util.Map;

public interface TravelMapRepositoryCustom {
	
	List<Map<String, Object>> getVisitedCountriesCountByUser(String username);
}
