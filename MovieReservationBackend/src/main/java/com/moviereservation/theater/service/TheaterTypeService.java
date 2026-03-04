package com.moviereservation.theater.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.moviereservation.theater.BETheaterType;
import com.moviereservation.theater.dto.TheaterTypeDTO;

public interface TheaterTypeService {
	public void createTheaterType(TheaterTypeDTO theater);
	public void updateTheaterType(Long id, TheaterTypeDTO theater);
	public void deleteTheaterType(Long id);
	public Optional<BETheaterType> findById(Long id);
	public List<BETheaterType> list(Pageable page);
}
