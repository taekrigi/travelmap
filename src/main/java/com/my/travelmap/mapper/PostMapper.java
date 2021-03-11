package com.my.travelmap.mapper;

import org.mapstruct.Mapper;

import com.my.travelmap.dto.PostDto;
import com.my.travelmap.entity.Post;
import com.my.travelmap.mapper.base.BaseMapper;
import com.my.travelmap.param.PostParam;

@Mapper(componentModel = "spring")
public interface PostMapper extends BaseMapper<Post, PostDto, PostParam> {

}
