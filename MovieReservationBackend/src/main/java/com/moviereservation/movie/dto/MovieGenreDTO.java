package com.moviereservation.movie.dto;

import com.moviereservation.movie.BEMovieGenre;

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
public class MovieGenreDTO {
	private String genre;
	
	public static MovieGenreDTO ofEntity(BEMovieGenre entity) {
		return MovieGenreDTO.builder()
				.genre(entity.getGenre())
				.build();
	}
}
