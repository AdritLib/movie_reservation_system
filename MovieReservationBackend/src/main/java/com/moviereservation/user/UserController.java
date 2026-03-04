package com.moviereservation.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviereservation.dto.ResponseDTO;
import com.moviereservation.enums.EnumResponseType;
import com.moviereservation.user.dto.UserLoginDTO;
import com.moviereservation.user.service.UserServiceImpl;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserLoginDTO body){
		if(userService.findByEmail(body.getEmail()).isEmpty()) return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(new ResponseDTO(LocalDateTime.now(), EnumResponseType.INFO, "The user data was updated."));
	}
}
