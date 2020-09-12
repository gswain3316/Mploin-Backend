package com.example.MPloin.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration.AnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MPloin.DataModel.Employee;
import com.example.MPloin.DataModel.Team;
import com.example.MPloin.Repository.EmplRepository;
import com.example.MPloin.Repository.TeamRepository;
import com.example.MPloin.Service.DatabaseOperationService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
public class DatabaseOperationController {

	@Autowired
	EmplRepository emp_repo;
	
	@Autowired
	DatabaseOperationService datapOps;
	
	@Autowired
	TeamRepository teamRepo;
	
	@Autowired
	MongoOperations mongoOps;
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<Object> getAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(emp_repo.findAll()); 
	}
	
	@PostMapping("/addTeams")
	public ResponseEntity<Object> addTeams (@RequestBody Team team){
		
		teamRepo.insert(team);
		List<Team> response = teamRepo.findAll().stream().collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee emp)
	{
		return ResponseEntity.status(HttpStatus.OK).body(emp_repo.insert(emp));
	}
	
	@PutMapping("/updateEmployeeData")
	public Employee updateEmployee(@RequestParam String email, 
			@RequestBody Employee employee)
	{
		Optional<Employee> emp = emp_repo.findByEmail(email);
		Employee empl = emp.get();
		if(emp.isPresent())
			{
			
			empl.setemail(employee.getemail());
			empl.setEmpl_name(employee.getEmpl_name());
			empl.setpassword(employee.getpassword());
			empl.setGender(employee.getGender());
			emp_repo.save(empl);
			
			/*
			 * mongoOps.updateFirst(new Query(Criteria.where("email").is(email)),
			 * Update.update("password", password), Employee.class);
			 */
			return empl; 	
			}
		else 
			return null;
//		return emp_repo.save(emp);
		//return ResponseEntity.status(HttpStatus.OK).body(emp_repo.save(emp));
	}
	
	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam String id)
	{
		emp_repo.deleteById(id);
		return "Employee deleted successfully from database !!";
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAllEmployee()
	{
		emp_repo.deleteAll();
		return "All Employees Data deleted from database !!";
	}
	
	@GetMapping("/getEmployeesInPages")
	public Map<String, Object> employeeInPages(@RequestParam( name = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam( name = "pageSize", defaultValue = "1") int pageSize,
			@RequestParam( name = "sortBy", defaultValue = "id") String sortBy)
	{
		return datapOps.employeeInPagesSer(pageNo, pageSize, sortBy);
	}
}
