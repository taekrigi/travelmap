package com.my.travelmap.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.my.travelmap.entity.base.BaseEntity;
import com.my.travelmap.param.CommentParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data 
public class Comment extends BaseEntity {

	private String writer;
	
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	public void update(CommentParam commentParam) {
		this.writer = commentParam.getWriter();
		this.content = commentParam.getContent();
	}
	
	
}
