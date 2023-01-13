package com.example.PrimeNumberGenerator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PrimeNumberGenerator.enums.Algo;
import com.example.PrimeNumberGenerator.models.PrimeModel;

@Service
public interface PrimeServiceInterf {
	
	List<Integer> call(int id, int start, int end, Algo algo);

	List<PrimeModel> getDetailsOfUser(int userId);

	List<PrimeModel> allPrimeGeneration();

}
