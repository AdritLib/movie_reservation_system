package com.moviereservation.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.theater.BETheaterSeat;

@Repository
public interface TheaterSeatRepository extends JpaRepository<BETheaterSeat, Long> {

}
