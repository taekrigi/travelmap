package com.my.travelmap.config;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.my.travelmap.security.JwtAuthenticationFilter;
import com.my.travelmap.security.JwtProperties;
import com.my.travelmap.security.JwtTokenVerifier;

import io.jsonwebtoken.security.Keys;
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
				.and()
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/h2/**", "/login").permitAll()
				.antMatchers(HttpMethod.POST, "/users").permitAll()
				.anyRequest().authenticated()
					.and()
				.addFilter(new JwtAuthenticationFilter(authenticationManager(), secretKey, jwtProperties))
				.addFilterAfter(new JwtTokenVerifier(secretKey, jwtProperties), JwtAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/h2/**").antMatchers(HttpMethod.POST, "/users");
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
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}