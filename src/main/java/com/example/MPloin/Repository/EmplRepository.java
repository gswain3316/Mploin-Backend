package com.example.MPloin.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MPloin.Entity.Employee;

@Repository
public interface EmplRepository extends MongoRepository<Employee, String> {
	
//	@Query("select e from employee e where e.empl_email = ?1")
	public Optional<Employee> findByEmail(String empl_email);	
}
