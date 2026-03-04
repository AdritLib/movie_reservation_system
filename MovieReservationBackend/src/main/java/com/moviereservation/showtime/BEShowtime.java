package com.moviereservation.showtime;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.moviereservation.movie.BEMovie;
import com.moviereservation.theater.BETheater;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "showtimes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BEShowtime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private BEMovie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id", nullable = false)
    private BETheater theater;

    @Column(nullable = false)
    private LocalDate dateBegin;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
}
