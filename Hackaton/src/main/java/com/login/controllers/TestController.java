package com.login.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/")
	public ResponseEntity<String> checkGetApi(){
		return ResponseEntity.ok("Login to Hackaton complete!");
	}
	
	@PostMapping("/")
	public ResponseEntity<String> checkPostApi(){
		return ResponseEntity.ok("Login to Hackaton complete!");
	}
}