package com.spring.authorizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.authorizationservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

		User findByUserName(String userName);

}
