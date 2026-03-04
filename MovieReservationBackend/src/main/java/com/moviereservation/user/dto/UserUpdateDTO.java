package com.moviereservation.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserUpdateDTO {
	private String username;
	private String email; 
	private String role;
}
