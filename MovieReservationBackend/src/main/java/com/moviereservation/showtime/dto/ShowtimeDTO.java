package com.moviereservation.showtime.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowtimeDTO {
	private Long movieId;
	private Long theaterId;
	private LocalDate dateBegin;
	private LocalTime startTime;
	private BigDecimal price;
}
