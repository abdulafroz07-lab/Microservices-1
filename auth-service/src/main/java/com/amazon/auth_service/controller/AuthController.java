package com.amazon.auth_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.auth_service.entity.User;
import com.amazon.auth_service.pojos.LoginData;
import com.amazon.auth_service.pojos.SignUpData;
import com.amazon.auth_service.service.AuthService;



@RestController
@RequestMapping("/auth/api")
public class AuthController {

	@Autowired
	AuthService authService;
	
	@PostMapping("/createAccount")
	public ResponseEntity<?> signUp(@RequestBody SignUpData signUpData) {
		User user = authService.signupService(signUpData);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginData loginData) throws Exception{
		User user = authService.loginService(loginData);
		return ResponseEntity.status(HttpStatus.OK).body(user);
		
	}
	
	@GetMapping("/ValidatingJWT")
	public ResponseEntity<?> validateJwtToken(@RequestHeader ("Authorization") String jwtToken){
		if (jwtToken.length()>0) {
			 return ResponseEntity.status(HttpStatus.OK).body(true);			
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NotValid");
		}
		
	}
	
	
}
