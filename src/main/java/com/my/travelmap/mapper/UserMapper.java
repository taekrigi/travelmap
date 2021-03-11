package com.my.travelmap.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.my.travelmap.dto.UserDto;
import com.my.travelmap.entity.User;
import com.my.travelmap.mapper.base.BaseMapper;
import com.my.travelmap.param.UserParam;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface UserMapper extends BaseMapper<User, UserDto, UserParam> {

	@Mapping(target = "authorities", ignore = true)
	@Mapping(target = "travelMaps", ignore = true)
	@Mapping(target = "userDetail", ignore = true)
	@Mapping(source = "password", target = "encryptedPassword", qualifiedBy = EncodedMapping.class)
	User toEntity(UserParam param);
}
