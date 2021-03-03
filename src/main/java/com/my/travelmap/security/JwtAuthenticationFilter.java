package com.my.travelmap.security;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.travelmap.param.UserParam;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;
	private final SecretKey secretKey;
	private final JwtProperties jwtProperties;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			UserParam userParam = new ObjectMapper().readValue(req.getInputStream(), UserParam.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
							userParam.getUsername(), 
							userParam.getPassword()
						)
					);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(2)))
                .signWith(secretKey)
                .compact();
	
		res.addHeader(jwtProperties.getHeader(), jwtProperties.getPrefix() + " " + token);
	}
}
