package com.my.travelmap.repository.travelmap;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.travelmap.entity.TravelMap;

public interface TravelMapRepository extends JpaRepository<TravelMap, UUID>, TravelMapRepositoryCustom {

	List<TravelMap> findAllByUser(String username);
}
