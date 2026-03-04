package com.moviereservation.reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.moviereservation.showtime.BEShowtime;
import com.moviereservation.showtime.BEShowtimeTheaterSeat;
import com.moviereservation.user.BEUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BEReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private BigDecimal totalPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private BEReservationStatus status;
	
	@Column(unique = true, nullable = false, length = 50)
	private String reservationCode;
	
	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private BEUser user;
	
	@OneToMany
	@JoinColumn(name = "showtime_id")
	private BEShowtime showtime;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "showtimes_theater_seat_id", nullable = false)
    private BEShowtimeTheaterSeat occupiedSeat;
}