package com.my.travelmap.util;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CommonUtilService {

	public static <T> T throwIfNotExist(Optional<T> t, Object searchParam) {
		return t.orElseThrow(() -> 
			new ResponseStatusException(HttpStatus.NOT_FOUND, searchParam + " is not found"));
	}
}
