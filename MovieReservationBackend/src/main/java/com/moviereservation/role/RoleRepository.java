package com.moviereservation.role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<BERole, Long> {
	public Optional<BERole> findByRole(String role);
}
