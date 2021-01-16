package com.example.MPloin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import com.example.MPloin.Exceptions.UserAlreadyExistsException;
import com.example.MPloin.Exceptions.UserNotFoundException;
import com.mploin.projects.Model.Employee;

public interface LoginService {
	
	public static final AuthenticationManager autheticationManager = null;
	boolean saveUser(Employee user) throws UserAlreadyExistsException, UserNotFoundException;
	
	public Employee findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;

	static Authentication signin(String email, String password) {
		return null;
	}

}
