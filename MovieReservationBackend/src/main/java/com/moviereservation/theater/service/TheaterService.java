package com.moviereservation.theater.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.moviereservation.theater.BETheater;
import com.moviereservation.theater.dto.TheaterDTO;

public interface TheaterService {
	public void createTheater(TheaterDTO theater);
	public void updateTheater(Long id, TheaterDTO theater);
	public void deleteTheater(Long id);
	public Optional<BETheater> findById(Long id);
	public List<BETheater> list(Pageable page);
}
