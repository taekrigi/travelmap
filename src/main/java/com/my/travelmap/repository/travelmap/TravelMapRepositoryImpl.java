package com.my.travelmap.repository.travelmap;

import static com.my.travelmap.entity.QTravelMap.travelMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TravelMapRepositoryImpl implements TravelMapRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<Map<String, Object>> getVisitedCountriesCountByUser(String username) {
		List<Tuple> data = jpaQueryFactory.from(travelMap)
			.where(travelMap.user.username.eq(username))
			.groupBy(travelMap.country)
			.select(travelMap.country, travelMap.country.count())
			.fetch();
		
		return null;
	}

}
