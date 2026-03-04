package com.moviereservation.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.reservation.BEReservation;

@Repository
public interface ReservationRepository extends JpaRepository<BEReservation, Long> {

}
