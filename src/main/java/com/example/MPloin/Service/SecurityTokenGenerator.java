package com.example.MPloin.Service;

import java.util.Map;

import com.mploin.projects.Model.Employee;



public interface SecurityTokenGenerator {
	Map<String, String> generateToken(Employee user);

}
