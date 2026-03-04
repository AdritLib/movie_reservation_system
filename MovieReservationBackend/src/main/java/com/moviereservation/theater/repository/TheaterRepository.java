package com.moviereservation.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.theater.BETheater;

@Repository
public interface TheaterRepository extends JpaRepository<BETheater, Long> {

}
