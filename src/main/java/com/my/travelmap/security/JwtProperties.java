package com.my.travelmap.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {
	
	private String secretKey;
	
	private String prefix;
	
	private String header;
	
	private int expirationTime;
}
