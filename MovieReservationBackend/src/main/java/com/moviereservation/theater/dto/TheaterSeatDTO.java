package com.moviereservation.theater.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeatDTO {
	private Long theaterId;
	private Long seatId;
}
