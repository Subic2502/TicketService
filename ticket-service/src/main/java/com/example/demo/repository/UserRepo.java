package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;


public interface UserRepo extends JpaRepository<User, Integer>{
	boolean existsByUsernameOrEmail(String username, String email);
	User findByUserId(Integer userId);
}
