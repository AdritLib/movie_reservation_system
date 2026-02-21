package com.moviereservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviereservation.model.BEUser;
import com.moviereservation.repository.UserRepository;

@Service
public class UserServiceImplemented implements UserService{

	@Autowired
	private UserRepository userRepos;
	
	@Override
	public Optional<BEUser> findByName(String name) {
		return userRepos.findByName(name);
	}

	@Override
	public Optional<BEUser> findById(Long id) {
		return userRepos.findById(id);
	}

}
