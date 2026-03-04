package com.moviereservation.user.service;

import java.util.Optional;

import com.moviereservation.user.BEUser;
import com.moviereservation.user.dto.UserUpdateDTO;

public interface UserService {
	public Optional<BEUser> findByName(String name);
	public Optional<BEUser> findByEmail(String email);
	public Optional<BEUser> findById(Long id);
	public void createUser(String username, String email, String rawPassword);
	public void updateUser(Long id, UserUpdateDTO user);
	public void updateUserPassword(Long id, String oldPassword, String newPassword);
}
