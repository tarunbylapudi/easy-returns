package com.spring.authorizationservice.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.authorizationservice.config.JwtUtil;
import com.spring.authorizationservice.entity.AuthResponse;
import com.spring.authorizationservice.entity.Credentials;
import com.spring.authorizationservice.excepction.InValidCredentials;
import com.spring.authorizationservice.service.MyUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService service;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	@CrossOrigin(origins  ="*")
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Credentials credentials) throws InValidCredentials {
		
		log.info("Invoked Authentication createAuthenticationToken ");
		

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(credentials.getUserName(), credentials.getPassword()));
		} catch (BadCredentialsException e) {
			log.debug("Incorrect username or password!");
			throw new InValidCredentials("Incorrect username or password!");
		}

		final UserDetails userDetails = service.loadUserByUsername(credentials.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		log.info("Jwt Token is Generated Successfully");

		return ResponseEntity.ok(new AuthResponse(jwt));
	}
	
	@CrossOrigin(origins  ="*")
	@GetMapping("/validate")
	protected boolean authorize(@RequestHeader("Authorization")String token)
			throws ServletException, IOException {
		
		log.info("Token Validated Successfully");
		return true;
	}

}