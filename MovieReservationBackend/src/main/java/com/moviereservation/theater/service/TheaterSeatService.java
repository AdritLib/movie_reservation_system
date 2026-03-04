package com.moviereservation.theater.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.moviereservation.theater.BETheaterSeat;
import com.moviereservation.theater.dto.TheaterSeatDTO;

public interface TheaterSeatService {
	public void createTheaterSeat(TheaterSeatDTO theaterSeat);
	public void updateTheaterSeat(Long id, TheaterSeatDTO theaterSeat);
	public void deleteTheaterSeat(Long id);
	public Optional<BETheaterSeat> findById(Long id);
	public List<BETheaterSeat> list(Pageable page);
}
