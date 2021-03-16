package com.my.travelmap.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.my.travelmap.dto.UserDto;
import com.my.travelmap.param.UserParam;
import com.my.travelmap.security.ApplicationUserDetails;
import com.my.travelmap.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')") 
	public List<UserDto> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and #username == authentication.name)")
    public UserDto getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
	}
	
	@PostMapping("register")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserParam userParam) throws URISyntaxException {
		UserDto userDto = userService.addUser(userParam);
		return ResponseEntity.created(new URI("/users/" + userDto.getUsername())).body(userDto);
	}
	
	@PutMapping("{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and athentication.principal.username == #username)")
	@PostAuthorize("authentication.principal.username = returnObject.username")
	public UserDto updateUser(@PathVariable("username") String username, @Valid @RequestBody UserParam userParam) {
		return userService.updateUser(username, userParam);
	}
	
	@DeleteMapping("{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and athentication.principal.username == #username)")
	@PostAuthorize("authentication.principal.username = returnObject.username")
	public UserDto deleteUser(@PathVariable("username") String username) {
		return userService.deleteUser(username);
	}
	
	@PutMapping("{username}/role/{role}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and athentication.principal.username == #username)")
	public UserDto updateUserRole(@PathVariable("role") String role, @PathVariable("username") String username) {
		return userService.updateUserRole(role, username);
	}
	
	@PostMapping("jwt")
	@PreAuthorize("isAuthenticated()")
	public Map<String, Object> validateJwt() {
		return userService.validateJwt();
	}
}
