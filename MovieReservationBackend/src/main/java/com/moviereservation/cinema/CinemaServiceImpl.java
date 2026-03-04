package com.moviereservation.cinema;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaRepository cinemaRepo;
	
	@Override
	public void createCinema(CinemaDTO dto) {
		BECinema entity = new BECinema();
		
		entity.setAddress(dto.getAddress());
		entity.setLocality(dto.getLocality());
		entity.setSublocality(dto.getSublocality());
		
		cinemaRepo.save(entity);
	}

	@Override
	public void updateCinema(Long id, CinemaDTO dto) {
		Optional<BECinema> result = findById(id);
		if(result.isEmpty()) return;
		
		BECinema entity = result.get();
		entity.setAddress(dto.getAddress());
		entity.setLocality(dto.getLocality());
		entity.setSublocality(dto.getSublocality());
		
		cinemaRepo.save(entity);
	}

	@Override
	public void deleteCinema(Long id) {
		cinemaRepo.deleteById(id);
	}

	@Override
	public Optional<BECinema> findById(Long id) {
		return cinemaRepo.findById(id);
	}

	@Override
	public List<BECinema> findAll() {
		return cinemaRepo.findAll();
	}

}
