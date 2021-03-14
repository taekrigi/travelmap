package com.my.travelmap.repository.travelmap;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.travelmap.entity.TravelMap;
import com.my.travelmap.entity.User;

public interface TravelMapRepository extends JpaRepository<TravelMap, UUID>, TravelMapRepositoryCustom {

	List<TravelMap> findAllByUserUsername(String username);
	
	boolean existsByUserAndCountry(User user, String country);
}
