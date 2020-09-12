package com.example.MPloin.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.MPloin.DataModel.Team;

@Repository
public interface TeamRepository extends MongoRepository<Team, Long> {
	
	Optional<Team> findById(Long id); 
		
}
