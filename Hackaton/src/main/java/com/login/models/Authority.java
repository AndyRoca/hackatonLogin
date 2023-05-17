package com.login.models;

import com.login.utils.AuthorityName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "authorities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {
	// Object properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private AuthorityName name;

	/*
	 * Constructor that only contains the "name" field with the purpose of automatically 
	 * assigning the ID without the need for us to define it or set the field to null.
	 */
	public Authority(AuthorityName name) {
		this.name = name;
	}
}