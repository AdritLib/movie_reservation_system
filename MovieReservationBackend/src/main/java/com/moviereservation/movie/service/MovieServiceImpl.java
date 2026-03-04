package com.moviereservation.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.moviereservation.movie.BEMovie;
import com.moviereservation.movie.dto.MovieDTO;
import com.moviereservation.movie.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepos;
	
	@Override
	public void createMovie(MovieDTO movie) {
		movieRepos.save(transformDTO(movie));
	}

	@Override
	public void updateMovie(Long id, MovieDTO data) {
		Optional<BEMovie> found = movieRepos.findById(id);
		if(found.isEmpty()) return;
		BEMovie movie = found.get();
		movie.setTitle(data.getTitle());
		movie.setDescription(data.getDescription());
		movie.setPosterURL(data.getPosterURL());
		//movie.setGenre(data.getGenre());
		movieRepos.save(movie);
	}

	@Override
	public void deleteMovie(Long id) {
		movieRepos.deleteById(id);
	}

	@Override
	public List<BEMovie> listByGenre(int page, String genre) {
		Pageable pageable = PageRequest.of(page, 10, Sort.by("genre").ascending());
		return movieRepos.findAll(pageable).toList();
	}

	@Override
	public List<BEMovie> list(int page) {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
		return movieRepos.findAll(pageable).toList();
	}
	
	@Override
	public Optional<BEMovie> findById(Long id) {
		return movieRepos.findById(id);
	}
	
	public BEMovie transformDTO(MovieDTO dto) {
		BEMovie result = new BEMovie();
		result.setTitle(dto.getTitle());
		result.setDescription(dto.getDescription());
		return result;
	}
}
