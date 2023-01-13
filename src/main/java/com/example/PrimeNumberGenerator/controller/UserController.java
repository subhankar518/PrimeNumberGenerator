package com.example.PrimeNumberGenerator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PrimeNumberGenerator.models.User;
import com.example.PrimeNumberGenerator.requestClass.CreateUserRequest;
import com.example.PrimeNumberGenerator.service.UserServiceInterf;

@RestController
public class UserController {
	
	@Autowired
	UserServiceInterf userServiceInterf;
	
	@PostMapping("/user/addUser")
	public ResponseEntity addUser(@Valid @RequestBody CreateUserRequest createUserRequest)
	{
		return new ResponseEntity(userServiceInterf.addUser(createUserRequest),HttpStatus.CREATED);
	}

	@GetMapping("/user/allUserDetails")
	public ResponseEntity getAllUser()
	{
		return new ResponseEntity(userServiceInterf.getAllUser(),HttpStatus.OK);
	}
	
	@GetMapping("/user/singleUser/{id}")
	public ResponseEntity getUserById(@RequestParam("id") int id)
	{
		return new ResponseEntity(userServiceInterf.getUserById(id),HttpStatus.OK);	
	}
	

}
