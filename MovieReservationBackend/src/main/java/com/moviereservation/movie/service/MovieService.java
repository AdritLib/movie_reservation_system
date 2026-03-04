package com.moviereservation.movie.service;

import java.util.List;
import java.util.Optional;

import com.moviereservation.movie.BEMovie;
import com.moviereservation.movie.dto.MovieDTO;

public interface MovieService {
	public void createMovie(MovieDTO movie);
	public void updateMovie(Long id, MovieDTO movie);
	public void deleteMovie(Long id);
	public Optional<BEMovie> findById(Long id);
	public List<BEMovie> listByGenre(int page, String genre);
	public List<BEMovie> list(int page);
}
