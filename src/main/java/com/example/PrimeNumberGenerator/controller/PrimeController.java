package com.example.PrimeNumberGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PrimeNumberGenerator.enums.Algo;
import com.example.PrimeNumberGenerator.service.PrimeServiceInterf;

@RestController
public class PrimeController {
	
	@Autowired
	PrimeServiceInterf primeServiceInterf;
	
	@PostMapping("/prime/numberGenerate")
	public ResponseEntity primeNumberGenerate(@RequestParam("userId") int userId,
			                        @RequestParam("startingRange") int startingRange,
			                        @RequestParam("endingRange") int endingRange,
			                        @RequestParam("algo") Algo algo)
	{
		return new ResponseEntity(primeServiceInterf.call(userId, startingRange, endingRange, algo),HttpStatus.OK);
	}
	
	@GetMapping("/prime/{userId}")
	public ResponseEntity singleUserList(@RequestParam("userId") int userId)
	{
		return new ResponseEntity(primeServiceInterf.getDetailsOfUser(userId),HttpStatus.OK);
	}
	
	@GetMapping("/prime/allGeneration")
	public ResponseEntity allPrimeGeneration()
	{
		return new ResponseEntity(primeServiceInterf.allPrimeGeneration(),HttpStatus.OK);
	}

}
