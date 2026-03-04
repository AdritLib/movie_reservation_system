package com.moviereservation.reservation.service;

import java.util.List;
import java.util.Optional;

import com.moviereservation.cinema.CinemaDTO;
import com.moviereservation.reservation.BEReservation;

public interface ReservationService {
	public void createReservation(CinemaDTO seat);
	public void updateReservation(Long id, CinemaDTO seat);
	public void deleteReservation(Long id);
	public Optional<BEReservation> findById(Long id);
	public List<BEReservation> findAllByUser(Long userId);
	public List<BEReservation> findAll();
}
