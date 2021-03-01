package com.my.travelmap.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TemplateController {

	@GetMapping("/api")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String getApi() {
		log.info(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
		return "Api for User"; 
	}
}
