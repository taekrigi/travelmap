package com.my.travelmap.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.my.travelmap.dto.UserDto;
import com.my.travelmap.entity.User;
import com.my.travelmap.mapper.UserMapper;
import com.my.travelmap.param.UserParam;
import com.my.travelmap.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	
	private final UserMapper userMapper;
	private final UserRepository userRepository;
	
	public List<UserDto> getUsers() {
		return userMapper.toListDto(userRepository.findAll());
	}
	
	public UserDto getUserByUsername(String username) {
		UserDto userDto = userMapper.toDto(findUserByUsername(username));
		return userDto;
	}
	
	private User findUserByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new IllegalArgumentException("user not found : " + username));
	}

	public UserDto addUser(@Valid UserParam userParam) {
		User user = userRepository.save(userMapper.toEntity(userParam));
		return userMapper.toDto(user);
	}
}
