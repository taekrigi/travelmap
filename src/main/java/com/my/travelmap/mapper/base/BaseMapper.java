package com.my.travelmap.mapper.base;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Base Mapper interface.
 *
 * @param <E> 엔티티 타입
 * @param <D> DTO 타입
 * @param <P> Param 타입
 */
public interface BaseMapper<E, D, P> {

	  E toEntity(P param);
	
	  D toDto(E entity);

	  default List<D> toListDto(List<E> entities) {
	    return entities.stream().map(this::toDto).collect(Collectors.toList());
	  }
}