package com.moviereservation.movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BEMovieStatus {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true, length = 30)
	private String status;
}
