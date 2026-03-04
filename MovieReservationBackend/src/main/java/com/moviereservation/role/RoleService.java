package com.moviereservation.role;

import java.util.Optional;

public interface RoleService {
	public void createSeat(String role);
	public void updateSeat(Long id, String role);
	public Optional<BERole> findByRole(String role);
}
