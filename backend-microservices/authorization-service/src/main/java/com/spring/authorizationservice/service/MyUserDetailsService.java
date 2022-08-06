package com.spring.authorizationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.authorizationservice.entity.MyUserDetails;
import com.spring.authorizationservice.entity.User;
import com.spring.authorizationservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user=repository.findByUserName(userName);
		
		if(user== null) {
			log.debug("User is not registered!");
			throw new UsernameNotFoundException(userName +" NOT found!!");
		}else {
			return new MyUserDetails(user);
		}
		
		
		
		
		
	
		 
	
	}
	
	

}
