package com.my.travelmap.repository.travelmap;

import java.util.List;
import java.util.Map;

import static com.my.travelmap.entity.QTravelMap.travelMap;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TravelMapRepositoryImpl implements TravelMapRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<Map<String, Integer>> getVisitedCountriesCountByUser(String username) {
		jpaQueryFactory.from(travelMap)
			.where(travelMap.user.username.eq(username))
			.groupBy(travelMap.country)
			.select(travelMap.country, travelMap.country.count())
			.fetch();

		return null;
	}

}
