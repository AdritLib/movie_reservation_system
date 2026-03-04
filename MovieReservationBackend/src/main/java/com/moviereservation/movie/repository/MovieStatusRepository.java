package com.moviereservation.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.movie.BEMovieStatus;

@Repository
public interface MovieStatusRepository extends JpaRepository<BEMovieStatus, Long>{

}
