package com.my.travelmap.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class UserDetail extends BaseEntity {

	private String address;
	
	private String nation;
	
	@OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
	private User user;
}
