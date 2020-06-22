package com.codereveal.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codereveal.app.domain.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {

	
}
