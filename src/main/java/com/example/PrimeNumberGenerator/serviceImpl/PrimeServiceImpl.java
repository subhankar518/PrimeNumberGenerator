package com.example.PrimeNumberGenerator.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<Integer> primeGenerate(int start, int end)
	{
		List<Integer> primes = new ArrayList<Integer>();
		List<Integer> ls = new ArrayList<Integer>();

		//Iterating through loop of start and end limits
		for (int i = 2; i <= end; i++) 
		{
			int flag = 0;
			
			//Sieve of Eratosthenes using Dynamic Programming
			for (Integer val : primes) 
			{
				if (i % val == 0) 
				{
					flag = 1;
				}
			}
			
			//Add to store of prime numbers
			if (flag == 0 && !primes.contains(i)) 
			{
				primes.add(i);
				
				if(i>=start && i<=end)
					ls.add(i);
			}
		}
		
		return ls;
	}

	@Override
	public void call(int id, int start,int end) {

		long startTime = System.nanoTime();
		List<Integer> lst = primeGenerate(start,end);
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
					.build();
			
			primeRepositoryInterf.save(primeModel);
		}			
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
