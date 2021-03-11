package com.my.travelmap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.my.travelmap.entity.base.BaseEntity;
import com.my.travelmap.param.UserParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6185527718013818299L;

	@Column(name = "username", unique = true)
	private String username;
	
	private String encryptedPassword;
	 
	private String role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<TravelMap> travelMaps;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_detail_id")
	private UserDetail userDetail;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Authority> authorities;
	
	public void update(UserParam userParam) {
		this.username = userParam.getUsername();
	}
		
	public void updateRole(String role) {
		this.role = role;
	}
}
