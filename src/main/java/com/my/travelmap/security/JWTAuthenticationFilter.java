package com.my.travelmap.security;

import static com.my.travelmap.security.SecurityConstants.EXPIRATION_TIME;
import static com.my.travelmap.security.SecurityConstants.HEADER_STRING;
import static com.my.travelmap.security.SecurityConstants.SECRET;
import static com.my.travelmap.security.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.travelmap.param.UserParam;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			UserParam userParam = new ObjectMapper().readValue(req.getInputStream(), UserParam.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
							userParam.getUsername(), 
							userParam.getPassword(),
							new ArrayList<>())
					);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		User user = (User) auth.getPrincipal();
		
		Claims claims = Jwts.claims().setSubject(user.getUsername());
		claims.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME));
	
		String token = Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
				.compact();
		
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + token);
		
		log.info("Bearer token is " + token);
	}
}
