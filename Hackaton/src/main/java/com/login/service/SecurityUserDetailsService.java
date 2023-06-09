package com.login.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.models.User;
import com.login.repository.UserRepository;
import com.login.security.SecurityUser;

/* 
 * We add the annotation @Service to let Spring know that this is a class that is used as a 
 * service component.
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {
	// We define a userRepository attribute of type userRepository, into which we will inject the 
	// userRepository instance from the constructor.
	private final UserRepository userRepository;

	// We inject an instance of userRepository into the class constructor.
	public SecurityUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// This method has been autogenerated upon implementing UserDetailsService.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// We obtain the user using the findByUserName method.
		Optional<User> optUser = this.userRepository.findByUsername(username);

		// If it exists, we return a user created based on the user.
		if (optUser.isPresent()) {
			return new SecurityUser(optUser.get());
		}
		// In the case that the user does not exist, we throw an exception of type 
		// UsernameNotFoundException.
		throw new UsernameNotFoundException("User not found: " + username);
	}

}