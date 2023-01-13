package com.example.PrimeNumberGenerator.requestClass;

import javax.validation.constraints.NotBlank;

import com.example.PrimeNumberGenerator.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateUserRequest {
	
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String contact;
	
	public User toUser()
	{
		return User.builder()
				.name(name)
				.email(email)
				.contact(contact)
				.build();
	}

}
