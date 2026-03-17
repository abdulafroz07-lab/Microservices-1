package com.amazon.auth_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.auth_service.entity.User;
import com.amazon.auth_service.pojos.LoginData;
import com.amazon.auth_service.pojos.SignUpData;
import com.amazon.auth_service.repository.LoginRepo;
import com.amazon.auth_service.repository.UserRepo;


@Service
public class AuthService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	LoginRepo loginRepo;
	
	public User signupService(SignUpData signupData) {
	
	User user = new User();
		
		user.setFirstName(signupData.getFirstName());
		user.setLastName(signupData.getLastName());
		user.setEmail(signupData.getEmail());
		user.setPasswordHash((signupData.getPassword()));
		user.setPhoneNumber(signupData.getPhoneNumber());
		
		loginRepo.save(user);
		return user;
	}
	
	public User loginService(LoginData loginData) throws Exception {
		
		Optional<User> dbData = loginRepo.findByEmail(loginData.getEmail());
		if (dbData.isEmpty()) {
			throw new Exception("user not found");
		}
		
		User user = dbData.get();
		if (user.getPasswordHash().equals(loginData.getPassword()) == false) {
			throw new Exception("Login failed");
		}else {
			return user;
		}
		
		}
}
