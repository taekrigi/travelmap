package com.my.travelmap.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.my.travelmap.dto.PostDto;
import com.my.travelmap.entity.Post;
import com.my.travelmap.mapper.base.BaseMapper;
import com.my.travelmap.param.PostParam;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper extends BaseMapper<Post, PostDto, PostParam> {

}
