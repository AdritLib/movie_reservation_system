package com.moviereservation.cinema;

import java.util.List;
import java.util.Optional;

public interface CinemaService {
	public void createCinema(CinemaDTO dto);
	public void updateCinema(Long id, CinemaDTO dto);
	public void deleteCinema(Long id);
	public Optional<BECinema> findById(Long id);
	public List<BECinema> findAll();
}
