package com.example.MPloin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MPloin.Repository.MongoClientRepository;

@RestController
public class MongoClientController {
	
	@Autowired
	MongoClientRepository mongoClientRepository;

	@GetMapping("/mongoClientgetAll")
	public List<Object> findAllEmployee()
	{
		return mongoClientRepository.findAll();
	}
	
}
