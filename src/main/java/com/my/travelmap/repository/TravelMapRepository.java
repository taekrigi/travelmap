package com.my.travelmap.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.travelmap.entity.TravelMap;

public interface TravelMapRepository extends JpaRepository<TravelMap, UUID> {

	List<TravelMap> findAllByUser(String username);
	
	// List<Map<String, Integer>> countByCountryAndGroupBy(String username);
}
