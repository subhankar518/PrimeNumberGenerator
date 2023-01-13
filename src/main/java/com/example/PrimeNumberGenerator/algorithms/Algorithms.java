package com.example.PrimeNumberGenerator.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms {
	
	public static List<Integer> primeNormal(int start, int end)
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
	
	public static List<Integer> primeEfficient(int start, int end)
	{
		boolean isPrime[]=new boolean[end+1];
		Arrays.fill(isPrime, true);
		isPrime[0]=false;
		isPrime[1]=true;
        for(int i=2;i*i<=end;i++)
        {
        	for(int j=i*i;j<=end;j+=i)
        	{
        		isPrime[j]=false;
        	}
        }
        List<Integer> lst=new ArrayList<>();
        for(int i=start;i<=end;i++)
        {
        	if(isPrime[i])
        	{
        		lst.add(i);
        	}
        }
        
        return lst;
	}
}
