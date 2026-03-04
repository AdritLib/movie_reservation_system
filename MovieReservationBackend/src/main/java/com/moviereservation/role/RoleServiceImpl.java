package com.moviereservation.role;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public void createSeat(String role) {
		BERole entity = new BERole();
		entity.setRole(role);
		roleRepo.save(entity);
	}

	@Override
	public void updateSeat(Long id, String role) {
		Optional<BERole> result = roleRepo.findById(id);
		if(result.isEmpty()) return;
		
		BERole entity = result.get();
		entity.setRole(role);
		
		roleRepo.save(entity);
	}

	@Override
	public Optional<BERole> findByRole(String role) {
		return roleRepo.findByRole(role);
	}

}
