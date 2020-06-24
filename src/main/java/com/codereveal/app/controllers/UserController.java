package com.codereveal.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.codereveal.app.exceptions.CustomException;
import com.codereveal.app.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {

		UserDto userDetails = userService.createUser(userDto);
		return new ResponseEntity<>(userDetails, HttpStatus.CREATED);

	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getUser(@PathVariable(required = true) Long userId) {

		UserDto userDetails = userService.getUserDetails(userId);

		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto) {

		if (null == userDto.getId() || userDto.getId() <= 0) {
			throw new CustomException("Invalid Id");
		}

		UserDto userDetails = userService.updateUser(userDto);

		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable(required = true) Long userId) {

		try {
			if (userId <= 0) {
				throw new CustomException("Invalid Id");
			}
			userService.deleteUser(userId);
		} catch (Exception e) {
			throw new CustomException("Error while Deleting Record");
		}
		
		Map<String,Object> map=new HashMap<>();
		map.put("message", "Record Deleted ID :: "+userId);

		return new ResponseEntity<Map>(map,HttpStatus.OK);
	}
}
