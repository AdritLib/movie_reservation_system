package com.moviereservation.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviereservation.reservation.BEReservationStatus;

@Repository
public interface ReservationStatusRepository extends JpaRepository<BEReservationStatus, Integer> {

}
