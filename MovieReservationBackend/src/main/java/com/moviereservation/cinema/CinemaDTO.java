package com.moviereservation.cinema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaDTO {
	private String locality;
	private String sublocality;
	private String address;
	
	public static CinemaDTO ofEntity(BECinema cinema) {
		return CinemaDTO.builder()
				.address(cinema.getAddress())
				.locality(cinema.getLocality())
				.sublocality(cinema.getSublocality())
				.build();
	}
}
