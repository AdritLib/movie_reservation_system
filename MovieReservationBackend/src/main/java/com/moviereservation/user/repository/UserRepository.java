package com.moviereservation.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.user.BEUser;

@Repository
public interface UserRepository extends JpaRepository<BEUser, Long> {
	public Optional<BEUser> findByUsername(String name);
	public Optional<BEUser> findByEmail(String email);
}
