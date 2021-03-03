package com.my.travelmap.repository.travelmap;

import java.util.List;

import com.my.travelmap.dto.VisitedCountryCountDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.my.travelmap.entity.QTravelMap.travelMap;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TravelMapRepositoryImpl implements TravelMapRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<VisitedCountryCountDto> getVisitedCountriesCountByUser(String username) {
		return jpaQueryFactory.from(travelMap)
				.where(travelMap.user.username.eq(username))
				.groupBy(travelMap.country)
				.select(
					Projections.constructor(
						VisitedCountryCountDto.class, 
						travelMap.country, 
						travelMap.country.count())
					)
				.fetch();
		
	}

}
