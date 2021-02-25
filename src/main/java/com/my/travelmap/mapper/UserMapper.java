package com.my.travelmap.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.my.travelmap.entity.User;
import com.my.travelmap.param.UserParam;

@Mapper(componentModel = "spring")
public interface UserMapper {

	User toEntity(UserParam userParam);
}
