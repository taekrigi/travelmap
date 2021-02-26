package com.my.travelmap.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.my.travelmap.param.UserParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class User extends BaseEntity {

	private String username;
	
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<TravelMap> travelMaps;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_detail_id")
	private UserDetail userDetail;
	
	public void update(UserParam userParam) {
		this.username = userParam.getUsername();
	}
}
