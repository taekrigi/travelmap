package com.my.travelmap.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserParam {

	@NotBlank
	private String username;
	
	@NotBlank
	private String password;

}
