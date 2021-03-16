package com.my.travelmap.config;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.my.travelmap.security.JwtAuthenticationFilter;
import com.my.travelmap.security.JwtProperties;
import com.my.travelmap.security.JwtTokenVerifier;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	private final UserDetailsService userDetailService;
	private final SecretKey secretKey;
	private final JwtProperties jwtProperties;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.and().csrf().disable()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.exceptionHandling()
					.authenticationEntryPoint((request, response, ex) -> {
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
					})
			.and()
				.authorizeRequests()
				 .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				.anyRequest().permitAll()
			.and()
				.addFilter(
					new JwtAuthenticationFilter(
							authenticationManager(), 
							secretKey, 
							jwtProperties
					)				)
				.addFilterAfter(
					new JwtTokenVerifier(secretKey, jwtProperties), 
					JwtAuthenticationFilter.class
				);
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailService);
        return provider;
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}