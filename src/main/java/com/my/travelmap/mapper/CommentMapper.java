package com.my.travelmap.mapper;

import org.mapstruct.Mapper;

import com.my.travelmap.dto.CommentDto;
import com.my.travelmap.entity.Comment;
import com.my.travelmap.mapper.base.BaseMapper;
import com.my.travelmap.param.CommentParam;

@Mapper(componentModel = "spring")
public interface CommentMapper extends BaseMapper<Comment, CommentDto, CommentParam> {

}
