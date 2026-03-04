package com.moviereservation.theater.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moviereservation.theater.BETheaterType;
import com.moviereservation.theater.dto.TheaterTypeDTO;
import com.moviereservation.theater.repository.TheaterTypeRepository;

@Service
public class TheaterTypeServiceImpl implements TheaterTypeService {

	@Autowired
	private TheaterTypeRepository theaterTypeRepo;
	
	@Override
	public void createTheaterType(TheaterTypeDTO theater) {
		BETheaterType entity = new BETheaterType();
		entity.setType(theater.getType());
		theaterTypeRepo.save(entity);
	}

	@Override
	public void updateTheaterType(Long id, TheaterTypeDTO theater) {
		Optional<BETheaterType> result = findById(id);
		if(result.isEmpty()) return;
		BETheaterType entity = result.get();
		entity.setType(theater.getType());
		theaterTypeRepo.save(entity);
	}

	@Override
	public void deleteTheaterType(Long id) {
		theaterTypeRepo.deleteById(id);
	}

	@Override
	public Optional<BETheaterType> findById(Long id) {
		return theaterTypeRepo.findById(id);
	}

	@Override
	public List<BETheaterType> list(Pageable page) {
		return theaterTypeRepo.findAll(page).toList();
	}

}
