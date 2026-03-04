package com.moviereservation.showtime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moviereservation.showtime.BEShowtime;
import com.moviereservation.showtime.BEShowtimeTheaterSeat;
import com.moviereservation.showtime.dto.ShowtimeTheaterSeatDTO;
import com.moviereservation.showtime.repository.ShowtimeRepository;
import com.moviereservation.showtime.repository.ShowtimeTheaterSeatRepository;
import com.moviereservation.theater.BETheaterSeat;
import com.moviereservation.theater.repository.TheaterSeatRepository;

@Service
public class ShowtimeTheaterSeatServiceImpl implements ShowtimeTheaterSeatService {

	@Autowired
	private ShowtimeTheaterSeatRepository showtimeTheaterSeatRepo;
	
	@Autowired
	private ShowtimeRepository showtimeRepo;
	
	@Autowired
	private TheaterSeatRepository theaterSeatRepo;
	
	@Override
	public void createShowtimeTheaterSeat(ShowtimeTheaterSeatDTO dto) {
		BEShowtimeTheaterSeat entity = new BEShowtimeTheaterSeat();
		
		Optional<BEShowtime> showtime = showtimeRepo.findById(dto.getShowtimeId());
		if(showtime.isEmpty()) return;
		entity.setShowtime(showtime.get());
		
		Optional<BETheaterSeat> theaterSeat = theaterSeatRepo.findById(dto.getTheaterSeatId());
		if(theaterSeat.isEmpty()) return;
		entity.setTheaterSeat(theaterSeat.get());
		
		showtimeTheaterSeatRepo.save(entity);
	}

	@Override
	public void updateShowtimeTheaterSeat(Long id, ShowtimeTheaterSeatDTO dto) {
		Optional<BEShowtimeTheaterSeat> result = findById(id);
		if(result.isEmpty()) return;
		BEShowtimeTheaterSeat entity = result.get();
		
		Optional<BEShowtime> showtime = showtimeRepo.findById(dto.getShowtimeId());
		if(showtime.isEmpty()) return;
		entity.setShowtime(showtime.get());
		
		Optional<BETheaterSeat> theaterSeat = theaterSeatRepo.findById(dto.getTheaterSeatId());
		if(theaterSeat.isEmpty()) return;
		entity.setTheaterSeat(theaterSeat.get());
		
		showtimeTheaterSeatRepo.save(entity);
	}

	@Override
	public void deleteShowtimeTheaterSeat(Long id) {
		showtimeTheaterSeatRepo.deleteById(id);
	}

	@Override
	public Optional<BEShowtimeTheaterSeat> findById(Long id) {
		return showtimeTheaterSeatRepo.findById(id);
	}

	@Override
	public List<BEShowtimeTheaterSeat> findAll(Pageable page) {
		return showtimeTheaterSeatRepo.findAll(page).toList();
	}

}
