package com.example.MPloin.Service;

import com.example.MPloin.DataModel.Employee;
import com.example.MPloin.Exceptions.UserAlreadyExistsException;
import com.example.MPloin.Exceptions.UserNotFoundException;

public interface LoginService {
	boolean saveUser(Employee user) throws UserAlreadyExistsException, UserNotFoundException;
	
	public Employee findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;

}
