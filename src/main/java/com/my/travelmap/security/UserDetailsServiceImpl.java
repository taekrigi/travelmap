package com.my.travelmap.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.travelmap.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.my.travelmap.entity.User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		
		Set<SimpleGrantedAuthority> authorities = user.getAuthorities()
				.stream()
				.map(auth -> auth.getAuthority())
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());
		
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		return new User(
				user.getUsername(), 
				user.getEncryptedPassword(), 
				true, 
				true, 
				true, 
				true, 
				authorities
			);
	}

}
