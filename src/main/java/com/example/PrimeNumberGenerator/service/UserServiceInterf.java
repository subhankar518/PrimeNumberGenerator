package com.example.PrimeNumberGenerator.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.example.PrimeNumberGenerator.models.User;
import com.example.PrimeNumberGenerator.requestClass.CreateUserRequest;

@Service
public interface UserServiceInterf {

	User addUser(CreateUserRequest createUserRequest);

	User findById(int id);

	List<User> getAllUser();

	User getUserById(int id);
}
