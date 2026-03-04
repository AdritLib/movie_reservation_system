package com.moviereservation.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.theater.BETheaterType;

@Repository
public interface TheaterTypeRepository extends JpaRepository<BETheaterType, Long>{

}
