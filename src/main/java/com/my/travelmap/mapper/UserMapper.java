package com.my.travelmap.mapper;

import org.mapstruct.Mapper;

import com.my.travelmap.dto.UserDto;
import com.my.travelmap.entity.User;
import com.my.travelmap.param.UserParam;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto, UserParam> {

}
