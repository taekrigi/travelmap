package com.my.travelmap.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;
import com.my.travelmap.dto.UserDto;
import com.my.travelmap.entity.User;
import com.my.travelmap.error.UserAlreadyExistsException;
import com.my.travelmap.mapper.UserMapper;
import com.my.travelmap.param.UserParam;
import com.my.travelmap.repository.user.UserRepository;
import com.my.travelmap.security.ApplicationUserDetails;
import com.my.travelmap.security.UserRole;
import com.my.travelmap.util.CommonUtilService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
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

	@Transactional
	public UserDto addUser(UserParam userParam) {
		boolean hasUser = userRepository.existsByUsername(userParam.getUsername());
		if (hasUser) throw new UserAlreadyExistsException(userParam.getUsername());
		return userMapper.toDto(userRepository.save(userMapper.toEntity(userParam)));
	}

	@Transactional
	public UserDto updateUser(String username, UserParam userParam) {
		User user = findUserByUsername(username);
		user.update(userParam);
		return userMapper.toDto(user);
	}

	@Transactional
	public UserDto deleteUser(String username) {
		User user = userRepository.deleteByUsername(username);
		return userMapper.toDto(user);
	}

	@Transactional
	public UserDto updateUserRole(String role, String username) {
		User user = findUserByUsername(username);
		user.updateRole(UserRole.of(role).getRole());
		return userMapper.toDto(user);
	}
	
	public User findUserByUsername(String username) {
		return CommonUtilService.throwIfNotExist(userRepository.findByUsername(username), username);
	}
	
	public Map<String, Object> validateJwt() {
		ApplicationUserDetails userDetails = (ApplicationUserDetails) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
		return ImmutableMap.of(
			"username", userDetails.getUsername(),
			"authorities", userDetails.getAuthorities().stream()
				.map(e -> e.getAuthority())
				.collect(Collectors.toSet())
		);
	}
}
