//package com.example.peice_pan.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Bean
//	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
//	http.authorizeRequests()
//
//	.antMatchers(HttpMethod.POST, "/piece/**").authenticated()
//
//	.antMatchers(HttpMethod.GET).authenticated()
//
//	. antMatchers(HttpMethod.POST, "/piece/logout").permitAll()
//
//	. anyRequest().authenticated()
//	.and().formLogin()
//	.and().httpBasic()
//
//	.and().csrf().disable();
//	return http.build();
//	}
//
//}
