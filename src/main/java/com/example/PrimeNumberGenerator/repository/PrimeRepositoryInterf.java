package com.example.PrimeNumberGenerator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.PrimeNumberGenerator.models.PrimeModel;

@Repository
public interface PrimeRepositoryInterf extends JpaRepository<PrimeModel, Integer>  {

	@Query(value="select * from prime_model pm where pm.user_id=?1",nativeQuery = true) 
	List<PrimeModel> findAllById(int userId);

}
