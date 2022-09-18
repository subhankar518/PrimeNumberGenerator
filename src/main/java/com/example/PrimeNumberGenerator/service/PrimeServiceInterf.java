package com.example.PrimeNumberGenerator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PrimeNumberGenerator.models.PrimeModel;

@Service
public interface PrimeServiceInterf {
	
	void call(int id, int start,int end);

	List<PrimeModel> getDetailsOfUser(int userId);

	List<PrimeModel> allPrimeGeneration();

}
