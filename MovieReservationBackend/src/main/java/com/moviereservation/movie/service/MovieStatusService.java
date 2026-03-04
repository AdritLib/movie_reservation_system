package com.moviereservation.movie.service;

import java.util.List;
import java.util.Optional;

import com.moviereservation.movie.BEMovieStatus;
import com.moviereservation.movie.dto.MovieStatusDTO;

public interface MovieStatusService {
	public void createGenre(MovieStatusDTO status);
	public void updateGenre(Long id, MovieStatusDTO status);
	public void deleteGenre(Long id);
	public Optional<BEMovieStatus> findById(Long id);
	public List<BEMovieStatus> findAll();
}
