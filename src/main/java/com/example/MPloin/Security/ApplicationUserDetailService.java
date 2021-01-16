package com.example.MPloin.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.MPloin.Exceptions.UserNotFoundException;
import com.example.MPloin.Repository.EmplRepository;
import com.example.MPloin.Entity.Employee;

public class ApplicationUserDetailService implements UserDetailsService{

	@Autowired
	private EmplRepository empRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			
		Employee emp;
		
		emp = empRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User does"
						+ "not exist"));
		
		
		return User.withUsername(emp.getEmail())
				.password(emp.getPassword())
				.authorities("USER")
				.accountExpired(false)
				.accountLocked(false)
				.credentialsExpired(false)
				.disabled(false)
				.build();
		
	}
	
	

}
