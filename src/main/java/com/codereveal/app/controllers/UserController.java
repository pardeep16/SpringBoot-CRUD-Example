package com.codereveal.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codereveal.app.domain.UserDto;
import com.codereveal.app.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
		
		UserDto userDetails=userService.createUser(userDto);
		return new ResponseEntity<>(userDetails,HttpStatus.CREATED);

	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUser(@PathVariable(required=true) Long userId) {
		
		UserDto userDetails=userService.getUserDetails(userId);
		
		return new ResponseEntity<>(userDetails,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto){
		
		return null;
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable(required=true) Long userId){
		return null;
	}
}
