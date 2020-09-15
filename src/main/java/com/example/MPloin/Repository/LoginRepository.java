package com.example.MPloin.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.MPloin.Entity.Employee;


@Repository
public interface LoginRepository extends MongoRepository<Employee, String>  {
	Employee findByEmailAndPassword(String email, String password);

}
