//package com.franchiseworld.taskmanager.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@EnableWebSecurity
//@Configuration
//
//public class SecurityConfig {
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable()).
//				authorizeHttpRequests(autorize -> autorize.anyRequest().authenticated())
//				.userDetailsService(userDetailsService()).httpBasic(Customizer.withDefaults());
//		return http.build();
//	}
//
//	// @formatter:off
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withUsername("user")
//				
//				.password("{noop}password")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user);
//	}
//	}
//
//
