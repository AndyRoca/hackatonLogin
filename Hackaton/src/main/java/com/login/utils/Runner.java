package com.login.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.login.models.Authority;
import com.login.models.User;
import com.login.repository.AuthorityRepository;
import com.login.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component // To execute the class when the application starts
@Slf4j // Lombok log for writing comments more easily
public class Runner implements CommandLineRunner {
	// Inject both dependencies into the Runner class
	private final UserRepository userRepository;
	private final AuthorityRepository authorityRepository;

	public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
		this.userRepository = userRepository;
		this.authorityRepository = authorityRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// If authorities do not exist, create the following:
		if (this.authorityRepository.count() == 0) {
			this.authorityRepository.saveAll(List.of(new Authority(AuthorityName.ADMIN), // Create AuthorityName.ADMIN
					new Authority(AuthorityName.READ), // Create AuthorityName.READ
					new Authority(AuthorityName.WRITE) // Create AuthorityName.WRITE
			));
			log.info("Authorities values was added!");
		}

		// If users do not exist, create the following:
		if (this.userRepository.count() == 0) {
			// Create users: 
			//User: AndyRoca, Pass: 2409, Authority: READ
			this.userRepository.save(new User("AndyRoca", new BCryptPasswordEncoder().encode("2409"),
					(List<Authority>) List.of(this.authorityRepository.findByName(AuthorityName.READ).get())));
			// User: Andres, Pass: 0924, Authority: WRITE
			this.userRepository.save(new User("Andres", new BCryptPasswordEncoder().encode("0924"),
					(List<Authority>) List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get())));
			// User: Rivera, Pass: 0429, Authority: ADMIN
			this.userRepository.save(new User("Rivera", new BCryptPasswordEncoder().encode("0429"),
					(List<Authority>) List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())));
			log.info("Users & relational tabled (N:M) values was added!");
		}
	}
}