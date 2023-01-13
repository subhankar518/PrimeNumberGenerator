package com.example.PrimeNumberGenerator.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PrimeNumberGenerator.algorithms.Algorithms;
import com.example.PrimeNumberGenerator.enums.Algo;
import com.example.PrimeNumberGenerator.models.PrimeModel;
import com.example.PrimeNumberGenerator.models.User;
import com.example.PrimeNumberGenerator.repository.PrimeRepositoryInterf;
import com.example.PrimeNumberGenerator.service.PrimeServiceInterf;
import com.example.PrimeNumberGenerator.service.UserServiceInterf;

@Service
public class PrimeServiceImpl implements PrimeServiceInterf {
	
	@Autowired
	UserServiceInterf userServiceInterf;
	
	@Autowired 
	PrimeRepositoryInterf primeRepositoryInterf;

	@Override
	public List<Integer> call(int id, int start,int end, Algo algo) {

		switch(algo)
		{
			case EFFICIENT:
			{
				long startTime = System.nanoTime();
				List<Integer> lst = Algorithms.primeEfficient(start,end);
				long endTime = System.nanoTime();
				long elapsed= endTime-startTime;  
				int size= lst.size();
						
				Date date = new Date(System.currentTimeMillis());
				
				User user=userServiceInterf.findById(id);
				
				if(user != null)
				{
					PrimeModel primeModel=PrimeModel.builder()
							.elapsed(elapsed)
							.user(user)
							.start(start)
							.end(end)
							.size(size)
							.date(date)
							.algo(algo)
							.build();
					
					primeRepositoryInterf.save(primeModel);
				}
				
				return lst;
			}
			
			case NORMAL:
			{
				long startTime = System.nanoTime();
				List<Integer> lst = Algorithms.primeNormal(start, end);
				long endTime = System.nanoTime();
				long elapsed= endTime-startTime;  
				int size= lst.size();
						
				Date date = new Date(System.currentTimeMillis());
				
				User user=userServiceInterf.findById(id);
				
				if(user != null)
				{
					PrimeModel primeModel=PrimeModel.builder()
							.elapsed(elapsed)
							.user(user)
							.start(start)
							.end(end)
							.size(size)
							.date(date)
							.algo(algo)
							.build();
					
					primeRepositoryInterf.save(primeModel);
				}
				
				return lst;
			}
			
		}
		return new ArrayList<Integer>();
		
	}

	@Override
	public List<PrimeModel> getDetailsOfUser(int userId) {
		return primeRepositoryInterf.findAllById(userId);
	}

	@Override
	public List<PrimeModel> allPrimeGeneration() {
		List<PrimeModel> lst=new ArrayList<>();
		primeRepositoryInterf.findAll().forEach(PrimeModel->lst.add(PrimeModel));
		return lst;
		
	}
}
