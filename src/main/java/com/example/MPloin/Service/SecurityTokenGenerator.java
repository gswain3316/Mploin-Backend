package com.example.MPloin.Service;

import java.util.Map;

import com.example.MPloin.DataModel.Employee;



public interface SecurityTokenGenerator {
	Map<String, String> generateToken(Employee user);

}
