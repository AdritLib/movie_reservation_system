package com.moviereservation.showtime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.showtime.BEShowtimeTheaterSeat;

@Repository
public interface ShowtimeTheaterSeatRepository extends JpaRepository<BEShowtimeTheaterSeat, Long>{

}
