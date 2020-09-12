package com.example.MPloin.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MPloin.DataModel.Employee;
import com.example.MPloin.Exceptions.UserAlreadyExistsException;
import com.example.MPloin.Exceptions.UserNotFoundException;
import com.example.MPloin.Repository.LoginRepository;



@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private  LoginRepository userRepo;

	
	@Override
	public boolean saveUser(Employee user) throws  UserAlreadyExistsException {
		Optional<Employee> u1 = userRepo.findById(user.getemail());
		if(u1.isPresent()) {
			throw new UserAlreadyExistsException("User with Id already exists");
		}
		userRepo.save(user);
		return true;
	}
	
	@Override
	public Employee findByUserIdAndPassword(String userId, String password) throws UserNotFoundException{
		Employee user = userRepo.findByEmailAndPassword(userId, password);
		if(user == null) {
			throw new UserNotFoundException("UserId and Password Incorrect");
			
		}
		return user;
	}
}
