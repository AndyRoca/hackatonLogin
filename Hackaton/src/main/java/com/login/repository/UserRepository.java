package com.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// Let's define a method that searches if a user exists by their username.
	Optional<User> findByUsername(String username);
}
