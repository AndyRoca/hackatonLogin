package com.login.security;

import org.springframework.security.core.GrantedAuthority;

import com.login.models.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority{
	private static final long serialVersionUID = 3182154365831196334L;
	
	// We add a user-type property
	final private Authority authority;
	
	@Override
	public String getAuthority() {
		// It will return the value of the authorityName contained in the user property.
		return authority.getName().toString(); 
	}

}