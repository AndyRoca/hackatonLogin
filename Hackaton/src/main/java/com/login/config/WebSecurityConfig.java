package com.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {
	/*
	 * It is used as a user credential manager to later work with Spring Security, allowing us to 
	 * retrieve user details such as their username, password, and roles, and provide them to 
	 * Spring Security to perform authentication and authorization correctly. This interface is a 
	 * fundamental part of the authentication process in Spring Security.
	 */
//	@Bean
//	public UserDetailsService userDetailsServiceImpl() {
//		UserDetails userDetails = User.withUsername("AndyRoca").password("2409").roles("read").build();
//		// It is one of the implementations that UserDetailsService provides us.
//		return new InMemoryUserDetailsManager(userDetails);
//	}

	/*
	 * Spring Security also needs to know who handles the passwords. To do this, we will create 
	 * a @Bean/method called passwordEncoder() that will return a PasswordEncoder. For now, 
	 * in our example, we will use the NoOpPasswordEncoder, even though it is not 
	 * recommended for production because passwords will be stored in plain text. This will 
	 * allow us to understand how this works, and later on, we will change the password encoder 
	 * to one that actually encrypts the password.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}