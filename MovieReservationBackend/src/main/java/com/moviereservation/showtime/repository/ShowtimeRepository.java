package com.moviereservation.showtime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.showtime.BEShowtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<BEShowtime, Long> {

}
