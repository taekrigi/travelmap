package com.my.travelmap.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.my.travelmap.entity.base.BaseEntity;
import com.my.travelmap.param.PostParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data 
public class Post extends BaseEntity {

	private String writer;
	
	private String title;
	
	private String content;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	public void update(PostParam postParam) {
		this.title = postParam.getTitle();
		this.content = postParam.getContent();
	}
}
