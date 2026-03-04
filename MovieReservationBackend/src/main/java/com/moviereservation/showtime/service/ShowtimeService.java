package com.moviereservation.showtime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.moviereservation.showtime.BEShowtime;
import com.moviereservation.showtime.dto.ShowtimeDTO;

public interface ShowtimeService {
	public void createShowtime(ShowtimeDTO showtime);
	public void updateShowtime(Long id, ShowtimeDTO showtime);
	public void deleteShowtime(Long id);
	public Optional<BEShowtime> findById(Long id);
	public List<BEShowtime> findAll(Pageable page);
}
