package com.example.PrimeNumberGenerator.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PrimeNumberGenerator.models.User;
import com.example.PrimeNumberGenerator.repository.UserRepositoryInterf;
import com.example.PrimeNumberGenerator.requestClass.CreateUserRequest;
import com.example.PrimeNumberGenerator.service.UserServiceInterf;

@Service
public class UserServiceImpl implements UserServiceInterf{
	
	@Autowired
	UserRepositoryInterf userRepositoryInterf;
	
	@Override
	public User addUser(CreateUserRequest createUserRequest) {
		return userRepositoryInterf.save(createUserRequest.toUser());
	}

	@Override
	public User findById(int id) {
		return userRepositoryInterf.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		ArrayList<User> allUser=new ArrayList<>();
		userRepositoryInterf.findAll().forEach(User->allUser.add(User));
		return allUser;
	}

	@Override
	public User getUserById(int id) {
		return userRepositoryInterf.findById(id).get();
	}

}
