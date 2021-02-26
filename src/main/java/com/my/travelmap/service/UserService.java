package com.my.travelmap.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.my.travelmap.dto.UserDto;
import com.my.travelmap.entity.User;
import com.my.travelmap.mapper.UserMapper;
import com.my.travelmap.param.UserParam;
import com.my.travelmap.repository.UserRepository;
import com.my.travelmap.util.CommonUtilService;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	
	private final UserMapper userMapper;
	private final UserRepository userRepository;
	private final JPAQueryFactory jpaQueryFactory;
	
	public List<UserDto> getUsers() {
		return userMapper.toListDto(userRepository.findAll());
	}
	
	public UserDto getUserByUsername(String username) {
		UserDto userDto = userMapper.toDto(findUserByUsername(username));
		return userDto;
	}

	public UserDto addUser(UserParam userParam) {
		User user = userRepository.save(userMapper.toEntity(userParam));
		return userMapper.toDto(user);
	}

	public UserDto updateUser(String username, UserParam userParam) {
		User user = findUserByUsername(username);
		user.update(userParam);
		return userMapper.toDto(user);
	}

	public UserDto deleteUser(String username) {
		User user = userRepository.deleteByUsername(username);
		return userMapper.toDto(user);
	}
	
	public User findUserByUsername(String username) {
		return CommonUtilService.throwIfNotExist(userRepository.findByUsername(username), username);
	}
}
