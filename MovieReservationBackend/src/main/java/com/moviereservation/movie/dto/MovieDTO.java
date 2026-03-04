package com.moviereservation.movie.dto;

import com.moviereservation.movie.BEMovie;

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
public class MovieDTO {
	private String title;
	private String description;
	private String genre;
	private String posterURL;
	
	public static MovieDTO ofEntity(BEMovie entity) {
		return MovieDTO.builder()
				.genre(entity.getGenre().getGenre())
				.description(entity.getDescription())
				.posterURL(entity.getPosterURL())
				.title(entity.getTitle())
				.build();
	}
}
