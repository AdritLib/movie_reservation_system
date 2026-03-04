package com.moviereservation.theater.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDTO {
	private String displayname;
	private boolean is_available;
	private Long typeId;
	private Long cinemaId;
}
