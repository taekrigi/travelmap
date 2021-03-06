package com.my.travelmap.repository.travelmap;

import static com.my.travelmap.entity.QTravelMap.travelMap;

import java.util.List;

import com.my.travelmap.dto.VisitedCountryCountDto;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

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
				.orderBy(new OrderSpecifier<>(Order.DESC, travelMap.country.count()))
				.fetch();
	}
	
	@Override
	public List<VisitedCountryCountDto> getVisitedCountriesCount() {
		return jpaQueryFactory.from(travelMap)
				.groupBy(travelMap.country)
				.select(
					Projections.constructor(
						VisitedCountryCountDto.class,
						travelMap.country,
						travelMap.country.count()
					)
				)
				.fetch();
	}

}
