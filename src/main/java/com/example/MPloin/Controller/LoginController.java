package com.example.MPloin.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.MPloin.DataModel.Employee;
import com.example.MPloin.Service.LoginService;
import com.example.MPloin.Service.SecurityTokenGenerator;

@RestController
@EnableWebMvc
@CrossOrigin("*")
@RequestMapping
//@RequestMapping("/api/v1/userservice")
public class LoginController {

	
	@Autowired
	private LoginService userService;
	
	@Autowired
	private SecurityTokenGenerator tokenGenerator;
	
//	@PostMapping("/register")
//	public ResponseEntity<?> registerUser(@RequestBody User user) {
//		try {
//			userService.saveUser(user);
//			return new ResponseEntity<String>("User Registered successfully", HttpStatus.CREATED);
//		}catch (Exception e) {
//			return new ResponseEntity<String>(" {\"message\":\"" + e.getMessage() +"\"}",HttpStatus.CONFLICT);
//		}
//	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Employee loginDetail) {
		try {
			String userId = loginDetail.getemail();
			String password = loginDetail.getpassword();
			
			if(userId == null || password == null) {
				throw new Exception("Username or Password cannot be empty");
			}
			Employee user = userService.findByUserIdAndPassword(userId, password);
			if(user == null) {
				throw new Exception("User with given Id does not exists");
			}
			String pwd = user.getpassword();
			if(!password.equals(pwd)) {
				throw new Exception("Invalid login credential, Please check username and password");
			}
			
			Map<String, String> map = tokenGenerator.generateToken(user);
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
		}
	}

}
