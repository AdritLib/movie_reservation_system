package com.moviereservation.movie.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.movie.BEMovie;

@Repository
public interface MovieRepository extends JpaRepository<BEMovie, Long> {
	public List<BEMovie> findByGenre(Pageable pageable, String genre);
}
