package com.my.travelmap.security;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationUserDetails extends User {
	
	private static final long serialVersionUID = 897049799676970301L;
	
	private UUID uuid;

	public ApplicationUserDetails(
			String username, 
			String password, 
			boolean enabled, 
			boolean accountNonExpired,
			boolean credentialsNonExpired, 
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			UUID uuid) {
		super(
			username, 
			password, 
			enabled, 
			accountNonExpired, 
			credentialsNonExpired, 
			accountNonLocked, 
			authorities
		);
		this.uuid = uuid;
	}
}
