package com.moviereservation.movie.service;

import java.util.List;
import java.util.Optional;

import com.moviereservation.movie.BEMovieGenre;
import com.moviereservation.movie.dto.MovieGenreDTO;

public interface MovieGenreService {
	public void createGenre(MovieGenreDTO genre);
	public void updateGenre(Long id, MovieGenreDTO genre);
	public void deleteGenre(Long id);
	public Optional<BEMovieGenre> findById(Long id);
	public List<BEMovieGenre> findAll();
}
