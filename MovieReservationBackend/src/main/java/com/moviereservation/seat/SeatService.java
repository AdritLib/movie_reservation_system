package com.moviereservation.seat;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

public interface SeatService {
	public void createSeat(SeatDTO seat);
	public void updateSeat(Long id, SeatDTO seat);
	public void deleteSeat(Long id);
	public Optional<BESeat> findById(Long id);
	public List<BESeat> findAll(Pageable page);
}
