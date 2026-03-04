package com.moviereservation.theater.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moviereservation.seat.BESeat;
import com.moviereservation.seat.SeatRepository;
import com.moviereservation.theater.BETheater;
import com.moviereservation.theater.BETheaterSeat;
import com.moviereservation.theater.dto.TheaterSeatDTO;
import com.moviereservation.theater.repository.TheaterRepository;
import com.moviereservation.theater.repository.TheaterSeatRepository;

@Service
public class TheaterSeatServiceImpl implements TheaterSeatService {

	@Autowired
	private TheaterSeatRepository theaterSeatRepo;
	
	@Autowired
	private SeatRepository seatRepo;
	
	@Autowired
	private TheaterRepository theaterRepo;
	
	@Override
	public void createTheaterSeat(TheaterSeatDTO theaterSeat) {
		BETheaterSeat entity = new BETheaterSeat();
		Optional<BESeat> seat = seatRepo.findById(theaterSeat.getSeatId());
		if(seat.isEmpty()) return;
		entity.setSeat(seat.get());
		
		Optional<BETheater> theater = theaterRepo.findById(theaterSeat.getTheaterId());
		if(theater.isEmpty()) return;
		entity.setTheater(theater.get());
		theaterSeatRepo.save(entity);
	}

	@Override
	public void updateTheaterSeat(Long id, TheaterSeatDTO theaterSeat) {
		Optional<BETheaterSeat> result = findById(id);
		if(result.isEmpty()) return;
		
		BETheaterSeat entity = result.get();
		Optional<BESeat> seat = seatRepo.findById(theaterSeat.getSeatId());
		
		if(seat.isEmpty()) return;
		entity.setSeat(seat.get());
		
		Optional<BETheater> theater = theaterRepo.findById(theaterSeat.getTheaterId());
		if(theater.isEmpty()) return;
		entity.setTheater(theater.get());
		
		theaterSeatRepo.save(entity);
	}

	@Override
	public void deleteTheaterSeat(Long id) {
		theaterSeatRepo.deleteById(id);
	}

	@Override
	public Optional<BETheaterSeat> findById(Long id) {
		return theaterSeatRepo.findById(id);
	}

	@Override
	public List<BETheaterSeat> list(Pageable page) {
		return theaterSeatRepo.findAll(page).toList();
	}
}