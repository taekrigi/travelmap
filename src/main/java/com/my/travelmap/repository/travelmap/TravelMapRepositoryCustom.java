package com.my.travelmap.repository.travelmap;

import java.util.List;
import java.util.Map;

public interface TravelMapRepositoryCustom {
	
	List<Map<String, Integer>> getVisitedCountriesCountByUser(String username);
}
