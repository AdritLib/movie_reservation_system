package com.moviereservation.showtime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moviereservation.movie.BEMovie;
import com.moviereservation.movie.repository.MovieRepository;
import com.moviereservation.showtime.BEShowtime;
import com.moviereservation.showtime.dto.ShowtimeDTO;
import com.moviereservation.showtime.repository.ShowtimeRepository;
import com.moviereservation.theater.BETheater;
import com.moviereservation.theater.repository.TheaterRepository;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {

	@Autowired
	private ShowtimeRepository showtimeRepo;
	
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private TheaterRepository theaterRepo;
	
	@Override
	public void createShowtime(ShowtimeDTO showtime) {
		BEShowtime entity = new BEShowtime();
		entity.setDateBegin(showtime.getDateBegin());
		entity.setPrice(showtime.getPrice());
		entity.setStartTime(showtime.getStartTime());
		
		Optional<BEMovie> movie = movieRepo.findById(showtime.getMovieId());
		if(movie.isEmpty()) return;
		
		Optional<BETheater> theater = theaterRepo.findById(showtime.getTheaterId());
		if(theater.isEmpty()) return;
		
		entity.setTheater(theater.get());
		entity.setMovie(movie.get());
		showtimeRepo.save(entity);
	}

	@Override
	public void updateShowtime(Long id, ShowtimeDTO showtime) {
		Optional<BEShowtime> result = findById(id);
		if(result.isEmpty()) return;
		BEShowtime entity = result.get();
		
		entity.setDateBegin(showtime.getDateBegin());
		entity.setPrice(showtime.getPrice());
		entity.setStartTime(showtime.getStartTime());
		
		Optional<BEMovie> movie = movieRepo.findById(showtime.getMovieId());
		if(movie.isEmpty()) return;
		
		Optional<BETheater> theater = theaterRepo.findById(showtime.getTheaterId());
		if(theater.isEmpty()) return;
		
		entity.setTheater(theater.get());
		entity.setMovie(movie.get());
		showtimeRepo.save(entity);
	}

	@Override
	public void deleteShowtime(Long id) {
		showtimeRepo.deleteById(id);
	}

	@Override
	public Optional<BEShowtime> findById(Long id) {
		return showtimeRepo.findById(id);
	}

	@Override
	public List<BEShowtime> findAll(Pageable page) {
		return showtimeRepo.findAll(page).toList();
	}

}
