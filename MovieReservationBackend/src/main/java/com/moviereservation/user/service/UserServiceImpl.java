package com.moviereservation.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.moviereservation.enums.EnumUserRole;
import com.moviereservation.user.BEUser;
import com.moviereservation.user.BEUserSecurity;
import com.moviereservation.user.dto.UserUpdateDTO;
import com.moviereservation.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserRepository userRepos;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Optional<BEUser> findByName(String name) {
		return userRepos.findByUsername(name);
	}

	@Override
	public Optional<BEUser> findById(Long id) {
		return userRepos.findById(id);
	}
	
	@Override
	public Optional<BEUser> findByEmail(String email) {
		return userRepos.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepos.findByUsername(username)
				.map(BEUserSecurity::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

	@Override
	public void createUser(String username, String email, String rawPassword) {
		BEUser user = new BEUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(rawPassword));
		user.setRole(EnumUserRole.USER.toString());
		userRepos.save(user);
	}

	@Override
	public void updateUser(Long id, UserUpdateDTO user) {
		BEUser entity = findById(id).orElseThrow();
		entity.setUsername(user.getUsername());
		entity.setEmail(user.getEmail());
		entity.setRole(user.getRole());
		userRepos.save(entity);
	}

	@Override
	public void updateUserPassword(Long id, String oldPassword, String newPassword) {
		BEUser user = findById(id).orElseThrow();
		user.setPassword(passwordEncoder.encode(newPassword));
		userRepos.save(user);
	}
}
