package com.moviereservation.showtime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.moviereservation.showtime.BEShowtimeTheaterSeat;
import com.moviereservation.showtime.dto.ShowtimeTheaterSeatDTO;

public interface ShowtimeTheaterSeatService {
	public void createShowtimeTheaterSeat(ShowtimeTheaterSeatDTO dto);
	public void updateShowtimeTheaterSeat(Long id, ShowtimeTheaterSeatDTO dto);
	public void deleteShowtimeTheaterSeat(Long id);
	public Optional<BEShowtimeTheaterSeat> findById(Long id);
	public List<BEShowtimeTheaterSeat> findAll(Pageable page);
}
