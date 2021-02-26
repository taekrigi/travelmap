package com.my.travelmap.mapper;

import org.mapstruct.Mapper;

import com.my.travelmap.dto.TravelMapDto;
import com.my.travelmap.entity.TravelMap;
import com.my.travelmap.param.TravelMapParam;

@Mapper(componentModel = "spring")
public interface TravelMapMapper extends BaseMapper<TravelMap, TravelMapDto, TravelMapParam> {

}
