package com.amazon.auth_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.auth_service.entity.User;



public interface LoginRepo extends JpaRepository<User, Integer> {

	
	Optional<User>  findByEmail(String email);
}

