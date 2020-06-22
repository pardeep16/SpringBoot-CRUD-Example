package com.codereveal.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codereveal.app.domain.UserDto;
import com.codereveal.app.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		UserDto user=userRepository.save(userDto);
		return user;
	}

	@Override
	public UserDto getUserDetails(Long userId) {
		Optional<UserDto> userDetails=userRepository.findById(userId);
		return userDetails.get();
	}

	@Override
	public int updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

}
