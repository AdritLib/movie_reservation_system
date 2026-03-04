package com.moviereservation.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.movie.BEMovieGenre;

@Repository
public interface MovieGenreRepository extends JpaRepository<BEMovieGenre, Long> {

}
