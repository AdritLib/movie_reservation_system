package com.moviereservation.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BEUserSecurity implements UserDetails{
	private static final long serialVersionUID = 1L;
	private final BEUser user;

	public BEUserSecurity(BEUser user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = user.getRole();
		String prefixedRole = role.startsWith("ROLE_") ? role : "ROLE_" + role;
		return List.of(new SimpleGrantedAuthority(prefixedRole));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}
}
