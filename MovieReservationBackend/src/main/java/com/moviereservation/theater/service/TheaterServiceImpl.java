package com.moviereservation.theater.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moviereservation.cinema.BECinema;
import com.moviereservation.cinema.CinemaRepository;
import com.moviereservation.theater.BETheater;
import com.moviereservation.theater.BETheaterType;
import com.moviereservation.theater.dto.TheaterDTO;
import com.moviereservation.theater.repository.TheaterRepository;
import com.moviereservation.theater.repository.TheaterTypeRepository;

@Service
public class TheaterServiceImpl implements TheaterService{

	@Autowired
	private TheaterRepository theaterRepo;
	
	@Autowired
	private CinemaRepository cinemaRepo;
	
	@Autowired
	private TheaterTypeRepository theaterTypeRepo;
	
	@Override
	public void createTheater(TheaterDTO theater) {
		BETheater entity = new BETheater();
		entity.setDisplayname(theater.getDisplayname());
		entity.setAvailable(theater.is_available());
		
		Optional<BECinema> cinema = cinemaRepo.findById(theater.getCinemaId());
		if(cinema.isEmpty()) return;
		
		Optional<BETheaterType> theaterType = theaterTypeRepo.findById(theater.getTypeId());
		if(theaterType.isEmpty()) return;
		
		entity.setCinema(cinema.get());
		entity.setType(theaterType.get());
		
		theaterRepo.save(entity);
	}

	@Override
	public void updateTheater(Long id, TheaterDTO theater) {
		Optional<BETheater> result = findById(id);
		
		if(result.isEmpty()) return;
		
		BETheater entity = result.get();
		
		entity.setDisplayname(theater.getDisplayname());
		entity.setAvailable(theater.is_available());
		
		Optional<BECinema> cinema = cinemaRepo.findById(theater.getCinemaId());
		if(cinema.isEmpty()) return;
		
		Optional<BETheaterType> theaterType = theaterTypeRepo.findById(theater.getTypeId());
		if(theaterType.isEmpty()) return;
		
		entity.setCinema(cinema.get());
		entity.setType(theaterType.get());
		
		theaterRepo.save(entity);
	}

	@Override
	public void deleteTheater(Long id) {
		theaterRepo.deleteById(id);
	}

	@Override
	public Optional<BETheater> findById(Long id) {
		return theaterRepo.findById(id);
	}

	@Override
	public List<BETheater> list(Pageable page) {
		return theaterRepo.findAll(page).toList();
	}
	
}
