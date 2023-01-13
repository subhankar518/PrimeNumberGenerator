package com.example.PrimeNumberGenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PrimeNumberGenerator.models.User;

@Repository
public interface UserRepositoryInterf extends JpaRepository<User, Integer> {

	User getByEmail(String email);

}
