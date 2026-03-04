package com.moviereservation.reservation.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
	private BigDecimal totalPrice;
	private String status;
	private LocalDateTime createdAt;
	private Long userId;
	private String reservationCode;
}
