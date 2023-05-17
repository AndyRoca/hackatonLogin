package com.login.security;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.login.models.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor  //We add the lombok constructor
public class SecurityUser implements UserDetails {
	private static final long serialVersionUID = 5319264677005477013L;

	// We add a property of type user
	final private User user;

	@Override
	public String getUsername() {
		return user.getUsername();// We return the username of the user object
	}

	@Override
	public String getPassword() {
		return user.getPassword(); // We return the password of the password object
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		/*
		 * Inside the getAuthorities() method of the SecurityUser class, we will return
		 * the list of security Authorities obtained from the list of Authorities of the
		 * users entity
		 */
		return user.getAuthorities().stream().map(SecurityAuthority::new).toList();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; //  Although we are not going to use them, we set them to true.
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; //  Although we are not going to use them, we set them to true.
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; //  Although we are not going to use them, we set them to true.
	}

	@Override
	public boolean isEnabled() {
		return true; //  Although we are not going to use them, we set them to true.
	}

}