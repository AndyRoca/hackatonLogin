package com.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.models.Authority;
import com.login.utils.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	// We create a method that will return an authority by its name.
	Optional<Authority> findByName(AuthorityName name);
}