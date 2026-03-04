package com.moviereservation.seat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService{

	@Autowired
	private SeatRepository seatRepo;
	
	@Override
	public void createSeat(SeatDTO seat) {
		BESeat entity = new BESeat();
		entity.setPosition(seat.getPosition());
		seatRepo.save(entity);
	}

	@Override
	public void updateSeat(Long id, SeatDTO seat) {
		Optional<BESeat> result = seatRepo.findById(id);
		if(result.isEmpty()) return;
		BESeat entity = new BESeat();
		entity.setPosition(seat.getPosition());
		seatRepo.save(entity);
	}

	@Override
	public void deleteSeat(Long id) {
		seatRepo.deleteById(id);
	}

	@Override
	public Optional<BESeat> findById(Long id) {
		return seatRepo.findById(id);
	}

	@Override
	public List<BESeat> findAll(Pageable page) {
		return seatRepo.findAll(page).toList();
	}

}
