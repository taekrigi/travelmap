package com.my.travelmap.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PasswordEncoderMapper {

	private final PasswordEncoder passwordEncoder;

	@EncodedMapping
	public String encode(String password) {
		return passwordEncoder.encode(password);
	}
}
