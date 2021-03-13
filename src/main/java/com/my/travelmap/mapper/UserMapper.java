package com.my.travelmap.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.my.travelmap.dto.UserDto;
import com.my.travelmap.entity.User;
import com.my.travelmap.mapper.base.BaseMapper;
import com.my.travelmap.param.UserParam;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<User, UserDto, UserParam> {

	@Mapping(source = "password", target = "encryptedPassword", qualifiedBy = EncodedMapping.class)
	User toEntity(UserParam param);
}
