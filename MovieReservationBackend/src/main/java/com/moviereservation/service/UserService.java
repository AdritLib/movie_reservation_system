package com.moviereservation.service;

import java.util.Optional;

import com.moviereservation.model.BEUser;

public interface UserService {
	public Optional<BEUser> findByName(String name);
	public Optional<BEUser> findById(Long id);
}
