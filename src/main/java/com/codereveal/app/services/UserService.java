package com.codereveal.app.services;

import com.codereveal.app.domain.UserDto;

public interface UserService {

	public UserDto createUser(UserDto userDto);
	
	public UserDto getUserDetails(Long userId);
	
	public UserDto updateUser(UserDto userDto);
	
	public void deleteUser(Long userId);
}
