package com.example.PrimeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class TestingMethods 
{
	
	public int primeGenerate(int start, int end)
	{

		List<Integer> primes = new ArrayList<Integer>();
		List<Integer> ls = new ArrayList<Integer>();

		for (int i = 2; i <= end; i++) 
		{
			int flag = 0;
			
			for (Integer val : primes) 
			{
				if (i % val == 0) 
				{
					flag = 1;
				}
			}
			
			if (flag == 0 && !primes.contains(i)) 
			{
				primes.add(i);
				
				if(i>=start && i<=end)
					ls.add(i);
			}
		}
		
		return ls.size();
	}
	

}
