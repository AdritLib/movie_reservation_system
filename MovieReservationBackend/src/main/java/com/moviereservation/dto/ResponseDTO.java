package com.moviereservation.dto;

import java.time.LocalDateTime;

import com.moviereservation.enums.EnumResponseType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDTO {
	private LocalDateTime executedAt;
	private EnumResponseType type;
	private String message;
}
