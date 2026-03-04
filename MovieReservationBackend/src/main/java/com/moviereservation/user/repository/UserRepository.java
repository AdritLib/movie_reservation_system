package com.moviereservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.model.BEUser;

@Repository
public interface UserRepository extends JpaRepository<BEUser, Long> {
	public Optional<BEUser> findByName(String name);
}
